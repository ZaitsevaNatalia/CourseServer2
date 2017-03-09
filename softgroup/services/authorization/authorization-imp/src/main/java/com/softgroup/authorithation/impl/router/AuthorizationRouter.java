package com.softgroup.authorithation.impl.router;

import com.softgroup.authorithation.impl.factory.AuthorizationHandlerFactory;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRouterHandler;
import com.softgroup.common.router.api.CommonRouterHandler;
import com.softgroup.common.router.api.Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationRouter<T extends AbstractRouterHandler> implements CommonRouterHandler{

    @Autowired
    private AuthorizationHandlerFactory authorizationHandlerFactory;



    public String getName()
    {
        return "authorization";
    }

    public Response<?> handle(Request<?> msg) {
        Handler handler = authorizationHandlerFactory.getHandler(msg);
        return handler.handle(msg);
    }

    public String getRouteKey(final Request<?> msg)
    {
        return null;
    }


}
