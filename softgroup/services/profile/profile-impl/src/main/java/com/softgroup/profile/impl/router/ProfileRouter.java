package com.softgroup.profile.impl.router;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.common.router.api.AbstractRouterHandler;
import com.softgroup.common.router.api.CommonRouterHandler;
import com.softgroup.common.router.api.Handler;
import com.softgroup.profile.impl.factory.ProfileHandlerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import com.softgroup.common.datamapper.JacksonDataMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProfileRouter<T extends AbstractRouterHandler> implements CommonRouterHandler{

    @Autowired
    private ProfileHandlerFactory profileHandlerFactory;

    public String getName()
    {
        return "profile";
    }

    public Response<?> handle(Request<?> msg) {
        Handler handler = profileHandlerFactory.getHandler(msg);
        return handler.handle(msg);
    }

    public String getRouteKey(final Request<?> msg)
    {
        return null;
    }


}
