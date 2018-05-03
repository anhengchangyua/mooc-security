package com.zhy.security;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;

public class DemoConnectionSigUp implements ConnectionSignUp {
    @Override
    public String execute(Connection<?> connection) {
        //根据connection中的信息默认创建用户
        return connection.getDisplayName();
    }
}
