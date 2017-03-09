package com.softgroup.authorithation.impl.factory;

import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.common.router.api.*;
import com.softgroup.common.router.impl.CommandFactory;
import org.springframework.stereotype.Service;

/**
 * Created by zajan on 03.03.2017.
 */
@Service
public class AuthorizationHandlerFactory extends CommandFactory<AuthorizationRequestHandler> implements HandlerFactory<AuthorizationRequestHandler> {

}
