package com.softgroup.profile.impl.factory;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.router.api.CommonRouterHandler;
import com.softgroup.common.router.api.Handler;
import com.softgroup.common.router.api.HandlerFactory;
import com.softgroup.common.router.impl.CommandFactory;
import com.softgroup.profile.api.router.ProfileRequestHandler;
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
public class ProfileHandlerFactory extends CommandFactory<ProfileRequestHandler> implements HandlerFactory<ProfileRequestHandler> {



}