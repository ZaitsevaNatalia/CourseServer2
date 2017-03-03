package com.softgroup.profile.api.message;

import com.softgroup.common.protocol.RequestData;

/**
 * Created by zajan on 03.03.2017.
 */
public class ContactSyncRequest implements RequestData {
    private String addedContacts;
    private String removedContacts;

    public String getAddedContacts() {
        return addedContacts;
    }

    public void setAddedContacts(String addedContacts) {
        this.addedContacts = addedContacts;
    }

    public String getRemovedContacts() {
        return removedContacts;
    }

    public void setRemovedContacts(String removedContacts) {
        this.removedContacts = removedContacts;
    }
}
