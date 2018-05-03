package com.zhy.security.app;


import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@Configuration
//添加默认的四种授权模式认证，实现了认证服务器
@EnableAuthorizationServer
public class ImoocAuthorizationServerConfig {

}
