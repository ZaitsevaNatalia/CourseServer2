package com.softgroup.authorithation.impl.handler;

import com.softgroup.authorization.api.message.LoginRequest;
import com.softgroup.authorization.api.message.LoginResponse;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by zajan on 03.03.2017.
 */
@Service
public class LoginHandler extends AbstractRequestHandler implements AuthorizationRequestHandler {

    public String id = "loginHandler";
    public String getName() {
        return "login";
    }

    public Response<?> handle(Request<?> msg)
    {
        return new Response<LoginResponse>();

    }
}
