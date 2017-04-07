package com.softgroup.common.token.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.io.Serializable;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import static sun.audio.AudioDevice.device;


/**
 * Created by zajan on 06.04.2017.
 */
@Component
public class JwtToken implements Serializable {

    private static final String issuer = "frewshyutredfbnj";

    private String createJWTDevice(String deviceID, String uuidOfUser) {

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        Long expirationMillis = TimeUnit.MILLISECONDS.convert(30, TimeUnit.DAYS);
        Date expiration = new Date(System.currentTimeMillis() + expirationMillis);

        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("secret");
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        Claims claims = Jwts.claims();
        claims.put("deviceID", deviceID);
        claims.put("tokenType", JwtTokenType.DEVICE_TOKEN);

        JwtBuilder builder = Jwts.builder()
                .setIssuedAt(now)
                .setId(UUID.randomUUID().toString())
                .setSubject(uuidOfUser)
                .setIssuer(issuer)
                .setClaims(claims)
                .setExpiration(expiration)
                .signWith(signatureAlgorithm, signingKey);

        return builder.compact();
    }

    private String createJWTShort(String deviceID, String userID) {

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        Long expirationMillis = TimeUnit.MILLISECONDS.convert(1, TimeUnit.HOURS);
        Date expiration = new Date(System.currentTimeMillis() + expirationMillis);

        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("secret");
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        Claims claims = Jwts.claims();
        claims.put("deviceID", deviceID);
        claims.put("tokenType", JwtTokenType.TOKEN);
        claims.put("userID", userID);

        JwtBuilder builder = Jwts.builder()
                .setIssuedAt(now)
                .setId(UUID.randomUUID().toString())
                .setIssuer(issuer)
                .setClaims(claims)
                .setExpiration(expiration)
                .signWith(signatureAlgorithm, signingKey);

        return builder.compact();
    }

    private void parseJWT(String jwt) {

        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary("secret"))
                .parseClaimsJws(jwt).getBody();
        System.out.println("ID: " + claims.getId());
        System.out.println("deviceID: " + claims.get("deviceID").toString());
        System.out.println("userID: " + claims.get("userID").toString());
        System.out.println("Expiration: " + claims.getExpiration());
        System.out.println("uuidOfUser: " + claims.getSubject());
        System.out.println("dateOfCreate: " + claims.getIssuedAt());
        System.out.println("jwtTokenType: " + claims.get("tokenType").toString());
    }

    private Claims getClaimsFromToken(String jwt) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary("secret"))
                    .parseClaimsJws(jwt).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    public String getUserID(String jwt) {
        String userID;
        try {
            final Claims claims = getClaimsFromToken(jwt);
            userID = claims.get("userID").toString();
        } catch (Exception e) {
            userID = null;
        }
        return userID;
    }

    public String getDeviceID(String jwt) {
        String deviceID;
        try {
            final Claims claims = getClaimsFromToken(jwt);
            deviceID = claims.get("deviceID").toString();
        } catch (Exception e) {
            deviceID = null;
        }
        return deviceID;
    }

    public Date getDateOfCreate(String jwt) {
        Date created;
        try {
            final Claims claims = getClaimsFromToken(jwt);
            created = claims.getIssuedAt();
        } catch (Exception e) {
            created = null;
        }
        return created;
    }

    public Date getExpirationDateFromToken(String jwt) {
        Date expiration;
        try {
            final Claims claims = getClaimsFromToken(jwt);
            expiration = claims.getExpiration();
        } catch (Exception e) {
            expiration = null;
        }
        return expiration;
    }

    private Boolean isTokenExpired(String jwt) {
        final Date expiration = getExpirationDateFromToken(jwt);
        return expiration.before(new Date());
    }

    public Boolean validateToken(String jwt, JwtTokenType type) {

        final String deviceID = getDeviceID(jwt);
        final String userID = getUserID(jwt);
        final Date created = getDateOfCreate(jwt);

        if (userID == null || deviceID == null)
            return false;

        return !isTokenExpired(jwt);
    }
}
