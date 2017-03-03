package com.softgroup.common.router.api;

import com.softgroup.common.factory.CoreFactory;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by zajan on 3/3/2017.
 */
public class CoreRouter<T extends AbstractRouterHandler> {
    @Autowired
    private CoreFactory coreFactory;

    public String getName()
    {
        return "routing";
    }

    public Response<?> handle(Request<?> msg) {
        Handler handler = coreFactory.getHandler(msg);
        return handler.handle(msg);
    }

    public String getRouteKey(final Request<?> msg)
    {
        return null;
    }
}
