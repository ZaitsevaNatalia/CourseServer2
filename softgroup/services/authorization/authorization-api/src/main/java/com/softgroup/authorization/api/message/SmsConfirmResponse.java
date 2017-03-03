package com.softgroup.authorization.api.message;

import com.softgroup.common.protocol.ResponseData;

/**
 * Created by zajan on 03.03.2017.
 */
public class SmsConfirmResponse implements ResponseData{
    private static final long serialVersionUID = -645554333912111546L;

    private String deviceToken;

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }
}
