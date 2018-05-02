package com.zhy.security.core.social;


import com.zhy.security.core.properties.BrowserProperties;
import com.zhy.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;

import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.security.SpringSocialConfigurer;


import javax.sql.DataSource;


@Configuration
@EnableSocial
public class SocialConfig extends SocialConfigurerAdapter {

    @Autowired
    DataSource dataSource;


    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        // connectionFactoryLocator: 查找ConnectionFactory
        JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator, Encryptors.noOpText());
        repository.setTablePrefix("imooc_");//为表 创建后缀
        return repository;
    }

    @Bean
    public SpringSocialConfigurer imoocSocialConfig() {
        String filterProcessUrl = securityProperties.getSocial().getFilterProcessUrl();
        imoocSpringSocialConfigurer configurer = new imoocSpringSocialConfigurer(filterProcessUrl);
        configurer.signupUrl(securityProperties.getBrowser().getSignUpUrl());
        return configurer;
    }

    @Bean
    public ProviderSignInUtils providerSignInUtils(ConnectionFactoryLocator connectionFactoryLocator) {
        return new ProviderSignInUtils(connectionFactoryLocator, getUsersConnectionRepository(connectionFactoryLocator)) {

        };
    }

}
