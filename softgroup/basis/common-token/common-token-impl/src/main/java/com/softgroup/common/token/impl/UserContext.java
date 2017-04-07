package com.softgroup.common.token.impl;

import com.softgroup.common.dao.api.entities.ProfileEntity;
import com.softgroup.common.dao.api.entities.ProfileSettingsEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

/**
 * Created by zajan on 27.03.2017.
 */
public class UserContext implements UserDetails {
    private ProfileEntity user;

    public UserContext(ProfileEntity user) {
        this.user = user;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        for (String role : user.getRoles()) {
            SimpleGrantedAuthority auth = new SimpleGrantedAuthority(role);
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }

    public String getPassword() {
        return user.getPassword();
    }

    public String getUsername() {
        return user.getName();
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;


        UserContext that = (UserContext) o;

        return user.equals(that.user);
    }

    @Override
    public int hashCode() {
        int result = user.getId().hashCode();
        result = 31*result;


        return result;
    }

    @Override
    public String toString() {
        return "UserContext{" +
                "user=" + user +
                '}';
    }
}
