package com.softgroup.common.factory;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.router.api.CommonRouterHandler;
import com.softgroup.common.router.api.Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zajan on 3/3/2017.
 */
@Service
public class CoreFactory<T extends AbstractHandlerFactory> {
    private Map<String, Handler> handlerMap= new HashMap<String, Handler>();

    @Autowired
    private List<CommonRouterHandler> handlers;

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
        return msg.getHeader().getType();
    }

    public String getName()
    {
        return "RoutingFactory";
    }
}
