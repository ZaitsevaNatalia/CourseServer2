package com.softgroup.common.token.impl;

import com.softgroup.common.dao.api.entities.ProfileEntity;
import com.softgroup.common.dao.impl.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by zajan on 27.03.2017.
 */
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserServiceImpl userDao;

    /**
     * This will be called from
     * {@link org.springframework.security.authentication.dao.DaoAuthenticationProvider#retrieveUser(java.lang.String, org.springframework.security.authentication.UsernamePasswordAuthenticationToken)}
     * when {@link AuthenticationService#authenticate(java.lang.String, java.lang.String)} calls
     * {@link AuthenticationManager#authenticate(org.springframework.security.core.Authentication)}. Easy.
     */

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(" *** MyUseDetailService.loadUserByUsername");
        ProfileEntity user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User " + username + " not found");
        }
        return new UserContext(user);
    }
}
