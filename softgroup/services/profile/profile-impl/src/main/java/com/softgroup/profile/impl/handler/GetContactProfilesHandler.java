package com.softgroup.profile.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.profile.api.message.ContactSyncResponse;
import com.softgroup.profile.api.message.GetContactProfilesResponse;
import com.softgroup.profile.api.router.ProfileRequestHandler;
import org.springframework.stereotype.Service;

/**
 * Created by zajan on 3/3/2017.
 */
@Service
public class GetContactProfilesHandler extends AbstractRequestHandler implements ProfileRequestHandler {
    public String getName() {
        return "get_contact_profiles";
    }

    public Response<?> handle(Request<?> msg)
    {
        return new Response<GetContactProfilesResponse>();

    }
}
