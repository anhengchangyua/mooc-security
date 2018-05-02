package com.zhy.security.core.social.qq.config;


import com.zhy.security.core.properties.SecurityProperties;
import com.zhy.security.core.social.qq.connect.QQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;


@Configuration
//此注解是为当imooc.security.social.qq.app-id下有值的时候才起作用
@ConditionalOnProperty(prefix = "imooc.security.social.qq", name = "app-id")
public class QQAutoConfig extends SocialAutoConfigurerAdapter {

    @Autowired
    SecurityProperties securityProperties;


    @Override
    protected ConnectionFactory<?> createConnectionFactory() {
        return new QQConnectionFactory(securityProperties.getSocial().getQq().getProviderId(), securityProperties.getSocial().getQq().getAppId(), securityProperties.getSocial().getQq().getAppSecret());
    }
}
