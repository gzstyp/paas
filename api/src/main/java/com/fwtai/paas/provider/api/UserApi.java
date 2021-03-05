package com.fwtai.paas.provider.api;

import java.io.Serializable;

public interface UserApi extends Serializable{

    public String login(final String userName,final String password);
}