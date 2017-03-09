package com.softgroup.common.router.api;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;

public abstract class AbstractRouterHandler implements RouterHandler {

    public abstract HandlerFactory getHandlerFactory();

    @Override
    public Response<?> handle(Request<?> msg)
    {
            return getHandlerFactory().getHandler(msg).handle(msg);
    }

}
