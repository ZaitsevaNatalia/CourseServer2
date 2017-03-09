package com.softgroup.common.router.api;


import com.softgroup.common.protocol.Request;
import com.softgroup.common.router.api.Handler;


import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by zajan on 28.02.2017.
 */
abstract public class AbstractHandlerFactory<T extends Handler> implements HandlerFactory {

}
