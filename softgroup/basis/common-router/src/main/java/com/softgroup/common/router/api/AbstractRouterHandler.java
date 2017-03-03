package com.softgroup.common.router.api;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;

public abstract class AbstractRouterHandler<T extends Handler> implements RouterHandler {

	/*@Override
	public String getRouteKey(Request<?> msg) {
		return null;
	}*/
	// Засунуть сюда абстрактную фабрику вместо мапы
	@Override
	public Response<?> handle(Request<?> msg)
	{
		return null;
	}

}
