package com.softgroup.common.token.impl;

import com.softgroup.common.token.api.TokenInfo;
import com.softgroup.common.token.api.TokenManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.util.Base64Utils;

import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.*;

import static java.lang.Class.forName;

/**
 * Created by zajan on 27.03.2017.
 */
public class TokenManagerSingle implements TokenManager {
    private Map<String, UserDetails> validUsers = new HashMap<String, UserDetails>();

    /**
     * This maps system users to tokens because equals/hashCode is delegated to User entity.
     * This can store either one token or list of them for each user, depending on what you want to do.
     * Here we store single token, which means, that any older tokens are invalidated.
     */
    private Map<UserDetails, TokenInfo> tokens = new HashMap<UserDetails, TokenInfo>();

    public TokenInfo createNewToken(UserDetails userDetails) {
        String token;
        do {
            token = generateToken();
        } while (validUsers.containsKey(token));

        TokenInfo tokenInfo = new TokenInfo(token, userDetails);
        removeUserDetails(userDetails);
        UserDetails previous = validUsers.put(token, userDetails);
        if (previous != null) {
            System.out.println(" *** SERIOUS PROBLEM HERE - we generated the same token (randomly?)!");
            return null;
        }
        tokens.put(userDetails, tokenInfo);

        return tokenInfo;
    }

    private String generateToken() {
        byte[] tokenBytes = new byte[32];
        new SecureRandom().nextBytes(tokenBytes);

        return new String(Base64.encode(tokenBytes));

    }

    public void removeUserDetails(UserDetails userDetails) {
        TokenInfo token = tokens.remove(userDetails);
        if (token != null) {
            validUsers.remove(token.getToken());
        }
    }

    public UserDetails removeToken(String token) {
        UserDetails userDetails = validUsers.remove(token);
        if (userDetails != null) {
            tokens.remove(userDetails);
        }
        return userDetails;
    }

    public UserDetails getUserDetails(String token) {
        return validUsers.get(token);
    }

    public Collection<TokenInfo> getUserTokens(UserDetails userDetails) {
        return Arrays.asList(tokens.get(userDetails));
    }

    public Map<String, UserDetails> getValidUsers() {
        return Collections.unmodifiableMap(validUsers);
    }
}
