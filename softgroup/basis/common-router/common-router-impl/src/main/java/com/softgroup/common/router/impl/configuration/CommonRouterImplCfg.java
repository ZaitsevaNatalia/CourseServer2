package com.softgroup.common.router.impl.configuration;


import com.softgroup.common.router.api.*;
import com.softgroup.common.router.impl.CommandFactory;
import com.softgroup.common.router.impl.CoreRouter;
import com.softgroup.common.router.impl.TypeFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zajan on 3/6/2017.
 */
@Configuration
public class CommonRouterImplCfg {
    @Bean
    public HandlerFactory<CommonRouterHandler> getTypeFactory() {
        return new TypeFactory();
    }
}
