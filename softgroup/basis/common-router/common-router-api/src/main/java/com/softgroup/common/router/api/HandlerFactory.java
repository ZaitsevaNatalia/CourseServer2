package com.softgroup.common.router.api;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.router.api.Handler;

public interface HandlerFactory<T extends Handler>
{
    Handler getHandler(Request<?> msg);
}
