package com.softgroup.authorithation.impl.handler;

import com.softgroup.authorization.api.message.RegisterResponse;
import com.softgroup.authorization.api.message.SmsConfirmResponse;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import org.springframework.stereotype.Service;

/**
 * Created by zajan on 03.03.2017.
 */
@Service
public class SmsConfirm extends AbstractRequestHandler implements AuthorizationRequestHandler {

    public String getName() {
        return "sms_confirm";
    }

    public Response<?> handle(Request<?> msg)
    {
        return new Response<SmsConfirmResponse>();
    }
}
