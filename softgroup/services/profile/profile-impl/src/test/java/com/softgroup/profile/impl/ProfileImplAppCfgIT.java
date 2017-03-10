package com.softgroup.profile.impl;

import com.softgroup.common.protocol.ActionHeader;
import com.softgroup.common.protocol.Request;
import com.softgroup.profile.api.message.GetMyProfileRequest;
import com.softgroup.profile.impl.configuration.ProfileImplCfg;
import com.softgroup.profile.impl.router.ProfileRouter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by zajan on 3/10/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ProfileImplCfg.class)
public class ProfileImplAppCfgIT {

    @Autowired
    private ProfileRouter profileRouter;

    @Test
    public void testGetMyProfile() {
        ActionHeader header = new ActionHeader();
        header.setCommand("get_my_profile");
        header.setType("profile");

        GetMyProfileRequest getMyProfileData = new GetMyProfileRequest();

        Request<GetMyProfileRequest> getMyProfileRequest = new Request<GetMyProfileRequest>();
        getMyProfileRequest.setHeader(header);
        getMyProfileRequest.setData(getMyProfileData);

        Assert.assertNotNull(profileRouter.handle(getMyProfileRequest));
    }

    @Test
    public void test(){
        String nameProfile = "profile";
        String name = profileRouter.getName();
        assertThat(name, is(nameProfile));
    }
}
