package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.RequestData;

/**
 * Created by zajan on 3/3/2017.
 */
public class SetMyProfileRequest implements RequestData {
    private String profile;

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
