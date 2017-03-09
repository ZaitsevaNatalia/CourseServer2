package com.softgroup.authorithation.impl.configuration;

import com.softgroup.authorithation.impl.factory.AuthorizationHandlerFactory;
import com.softgroup.authorithation.impl.handler.LoginHandler;
import com.softgroup.authorithation.impl.handler.RegistrationHandler;
import com.softgroup.authorithation.impl.handler.SmsConfirmHandler;
import com.softgroup.authorithation.impl.router.AuthorizationRouter;
import com.softgroup.authorization.api.router.AuthorizationRequestHandler;
import com.softgroup.common.router.api.CommonRouterHandler;
import com.softgroup.common.router.api.HandlerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zajan on 3/8/2017.
 */
@Configuration
@ComponentScan("com.softgroup.authorithation.impl")
public class AuthorizationImplCfg {

}
