package com.softgroup.profile.impl.factory;

import com.softgroup.common.factory.AbstractHandlerFactory;
import com.softgroup.common.factory.HandlerFactory;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.router.api.CommonRouterHandler;
import com.softgroup.common.router.api.Handler;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zajan on 03.03.2017.
 */
@Service
public class ProfileHandlerFactory<T extends AbstractHandlerFactory> {

    private Map<String, Handler> handlerMap= new HashMap<String, Handler>();

    @Autowired
    private List<ProfileRequestHandler> handlers;

    @PostConstruct
    public void init(){
        for (Handler handler : handlers)
        {
            handlerMap.put(handler.getName(), handler);
        }
    }

    public Handler getHandler(Request<?> msg) {
        String key = this.getKey(msg);
        return handlerMap.get(key);
    }

    public String getKey(Request<?> msg)
    {
        return msg.getHeader().getCommand();
    }

    public String getName()
    {
        return "ProfileFactory";
    }

}