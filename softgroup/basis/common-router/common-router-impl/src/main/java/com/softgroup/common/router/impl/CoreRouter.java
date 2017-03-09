package com.softgroup.common.router.impl;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRouterHandler;
import com.softgroup.common.router.api.Handler;
import com.softgroup.common.router.api.HandlerFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class CoreRouter<T extends AbstractRouterHandler> {

    @Autowired
    private TypeFactory typeFactory;

    public String getName()
    {
        return "routing";
    }

    public Response<?> handle(Request<?> msg) {
        Handler handler = typeFactory.getHandler(msg);
        return handler.handle(msg);
    }

    public String getRouteKey(final Request<?> msg)
    {
        return null;
    }
}
