package com.softgroup.common.factory;

/**
 * Created by zajan on 03.03.2017.
 */
import com.softgroup.common.protocol.Request;
import com.softgroup.common.router.api.Handler;

public interface HandlerFactory<T extends Handler>
{
    Handler getHandler(Request<?> msg);
}
