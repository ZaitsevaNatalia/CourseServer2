package com.softgroup.authorization.impl;

import com.softgroup.authorithation.impl.configuration.AuthorizationImplCfg;
import com.softgroup.authorithation.impl.factory.AuthorizationHandlerFactory;
import com.softgroup.authorithation.impl.handler.LoginHandler;
import com.softgroup.authorithation.impl.router.AuthorizationRouter;
import com.softgroup.authorization.api.message.LoginRequest;
import com.softgroup.authorization.api.message.RegisterRequest;
import com.softgroup.common.protocol.ActionHeader;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.Handler;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AuthorizationImplCfg.class)
public class AuthorizationImplAppCfgIT {

    @Autowired
    private AuthorizationRouter authorizationRouter;

    @Autowired
    private LoginHandler loginHandler;

    @Test
    public void testLogin() {
        ActionHeader header = new ActionHeader();
        header.setCommand("login");
        header.setType("authorization");


        LoginRequest loginData = new LoginRequest();
        loginData.setDeviceToken(UUID.randomUUID().toString());

        Request<LoginRequest> loginRequest = new Request<LoginRequest>();
        loginRequest.setHeader(header);
        loginRequest.setData(loginData);

        Assert.assertNotNull(authorizationRouter.handle(loginRequest));
    }
}

