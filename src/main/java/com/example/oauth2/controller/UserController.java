package com.example.oauth2.controller;

import com.example.oauth2.model.CodeMessage;
import com.example.oauth2.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.session.data.redis.RedisOperationsSessionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserMapper userService;

    @Autowired
    private HttpSession session;

    @Autowired
    RedisOperationsSessionRepository redisOperationsSessionRepository;

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('FIND_USER')")
    public CodeMessage getAllUser(){
        try{
            return CodeMessage.SUCCESS(userService.findAllUser());
        }catch (Exception e){
            return CodeMessage.ERROR;
        }
    }

    // 获取当前用户信息
    @GetMapping("/me")
    public Principal getUser(Principal principal) {
        return principal;
    }

    // 强制用户登出系统
    @GetMapping(value = "/forceLogout")
    public CodeMessage forceLogout(int userId){
        try{
            String sessionId = userService.getSesssionIdByUserId(userId);
            redisOperationsSessionRepository.deleteById(sessionId);
        }catch (Exception e){
            return CodeMessage.ERROR;
        }
        return CodeMessage.SUCCESS;
    }

}
