package com.softgroup.common.factory;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.router.api.Handler;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zajan on 28.02.2017.
 */
abstract public class AbstractHandlerFactory implements HandlerFactory {
    Map<String, Handler> handlerMap;

    public Handler getHandler(Request<?> msg) {
        String key = this.getKey(msg);
        return handlerMap.get(key);
    }

    abstract String getKey(Request<?> msg);
}
