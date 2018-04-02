package com.zhy.security.core;


import com.zhy.security.core.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
//让SecurityProperties读取器生效
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {


}
