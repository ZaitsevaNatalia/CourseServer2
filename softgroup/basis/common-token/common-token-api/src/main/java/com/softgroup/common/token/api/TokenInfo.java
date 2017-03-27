package com.softgroup.common.token.api;

import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by zajan on 24.03.2017.
 */
public final class TokenInfo {

    private final long created = System.currentTimeMillis();
    private final String token;
    private final UserDetails userDetails;
    // TODO expiration etc

    public TokenInfo(String token, UserDetails userDetails) {
        this.token = token;
        this.userDetails = userDetails;
    }

    public String getToken() {
        return token;
    }

    @Override
    public String toString() {
        return "TokenInfo{" +
                "token='" + token + '\'' +
                ", userDetails" + userDetails +
                ", created=" + new Date(created) +
                '}';
    }
}
