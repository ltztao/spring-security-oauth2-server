package com.example.oauth2.service;

import com.example.oauth2.mapper.PermissionMapper;
import com.example.oauth2.mapper.UserMapper;
import com.example.oauth2.model.Permission;
import com.example.oauth2.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(MyUserDetailsService.class);

    @Autowired
    private UserMapper       userService;
    @Autowired
    private PermissionMapper permissionService;

    public UserDetails loadUserByUsername(String username){

        User user = userService.findUserByUserName(username);
        if(user != null) {
            List<Permission> permissions = permissionService.findPermissionByUserId(user.getUserId());
            user.setPermissions(permissions);
            return  user;
        }
        return null;
    }

}
