package com.softgroup.common.router.impl;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.router.api.*;
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
public class CommandFactory<T extends RequestHandler> {

    private Map<String, Handler> handlerMap= new HashMap<String, Handler>();

    @Autowired
    private List<T> handlers;

    @PostConstruct
    public void init(){
        for (Handler handler : handlers)
        {
            handlerMap.put(handler.getName(), handler);
        }
    }

    public Handler getHandler(Request<?> msg) {
        String key = this.getRouteKey(msg);

        return handlerMap.get(key);
    }

    public String getRouteKey(Request<?> msg)
    {
        return msg.getHeader().getCommand();
    }

}
