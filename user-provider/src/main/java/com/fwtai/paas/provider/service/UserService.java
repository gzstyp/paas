package com.fwtai.paas.provider.service;

import com.fwtai.paas.provider.api.UserApi;
import com.fwtai.paas.provider.config.ConfigFile;
import com.fwtai.paas.provider.tool.ToolClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserApi{

    @Autowired
    private ConfigurableApplicationContext context;

    @Value("${server.port}")
    private String port;

    @Override
    public String login(final String userName,final String password){
        if(userName.equals(password)){
            return ToolClient.createJson(ConfigFile.code200,"登录成功");
        }
        final String result = context.getEnvironment().getProperty("server.port")+",userName->"+userName+",password->"+password+",port->"+port;
        return ToolClient.queryJson(result);
    }
}