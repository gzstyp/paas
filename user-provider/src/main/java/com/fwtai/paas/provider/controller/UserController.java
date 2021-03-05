package com.fwtai.paas.provider.controller;

import com.fwtai.paas.provider.service.UserService;
import com.fwtai.paas.provider.tool.ToolClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController{

    @Autowired
    private UserService userService;

    // http://127.0.0.1:10241/login?userName=typ&password=typ
    // http://127.0.0.1:10242/login?userName=typ&password=typ0
    @GetMapping("/login")
    public void login(final HttpServletRequest request,final HttpServletResponse response){
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        final String json = userService.login(userName,password);
        ToolClient.responseJson(json,response);
    }
}