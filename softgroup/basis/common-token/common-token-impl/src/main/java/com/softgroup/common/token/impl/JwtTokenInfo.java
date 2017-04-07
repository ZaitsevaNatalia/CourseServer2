package com.softgroup.common.token.impl;

/**
 * Created by zajan on 07.04.2017.
 */
public class JwtTokenInfo {

    private final String deviceID;
    private final String userID;
    private final String tokenType;
    private final Long timeOfCreate;
    private final Long timeOfExpire;

    private JwtTokenInfo(final String newDeviceID, final String newUserID, final String newTokenType, final Long newTimeOfCreate, final Long newTimeOfExpire){
        this.deviceID = newDeviceID;
        this.userID = newUserID;
        this.tokenType = newTokenType;
        this.timeOfCreate = newTimeOfCreate;
        this.timeOfExpire = newTimeOfExpire;
    }

    public Long getTimeOfExpire() {
        return timeOfExpire;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public String getUserID() {
        return userID;
    }

    public String getTokenType() {
        return tokenType;
    }

    public Long getTimeOfCreate() {
        return timeOfCreate;
    }

    public static class JwtTokenInfoBuilder{
        private String nestedDeviceID;
        private String nestedUserID;
        private String nestedTokenType;
        private Long nestedTimeOfCreate;
        private Long nestedTimeOfExpire;

        public JwtTokenInfoBuilder deviceID(String deviceID) {
            this.nestedDeviceID = deviceID;
            return this;
        }

        public JwtTokenInfoBuilder userID(String userID) {
            this.nestedUserID = userID;
            return this;
        }

        public JwtTokenInfoBuilder tokenType(String tokenType) {
            this.nestedTokenType = tokenType;
            return this;
        }

        public JwtTokenInfoBuilder timeOfCreate(Long timeOfCreate) {
            this.nestedTimeOfCreate = timeOfCreate;
            return this;
        }

        public JwtTokenInfoBuilder timeOfExpire(Long timeOfExpire) {
            this.nestedTimeOfExpire = timeOfExpire;
            return this;
        }

        public JwtTokenInfo build() {
            return new JwtTokenInfo(
                    nestedDeviceID, nestedUserID, nestedTokenType,
                    nestedTimeOfCreate, nestedTimeOfExpire);
        }
    }
}
