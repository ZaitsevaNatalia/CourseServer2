package com.softgroup.profile.impl.configuration;

import com.softgroup.common.router.api.CommonRouterHandler;
import com.softgroup.common.router.api.HandlerFactory;
import com.softgroup.common.router.impl.TypeFactory;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import com.softgroup.profile.impl.factory.ProfileHandlerFactory;
import com.softgroup.profile.impl.handler.*;
import com.softgroup.profile.impl.router.ProfileRouter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zajan on 3/8/2017.
 */
@Configuration
@ComponentScan("com.softgroup.profile.impl")
public class ProfileImplCfg {

}
