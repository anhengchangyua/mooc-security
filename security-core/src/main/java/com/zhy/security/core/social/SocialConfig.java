package com.zhy.security.core.social;

<<<<<<< HEAD
import com.zhy.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
=======
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> f891eae53efffc86ccdc969ae2f58a0d7395b385
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
<<<<<<< HEAD
import org.springframework.social.security.SpringSocialConfigurer;
=======
>>>>>>> f891eae53efffc86ccdc969ae2f58a0d7395b385

import javax.sql.DataSource;


@Configuration
@EnableSocial
public class SocialConfig extends SocialConfigurerAdapter {

    @Autowired
    DataSource dataSource;

<<<<<<< HEAD
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
    public SpringSocialConfigurer imoocSocialConfig(){
        String filterProcessUrl = securityProperties.getSocial().getFilterProcessUrl();
        imoocSpringSocialConfigurer configurer = new imoocSpringSocialConfigurer(filterProcessUrl);
        return configurer;
    }
=======
    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        //为表 创建后缀
        JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator, Encryptors.noOpText());
        repository.setTablePrefix("imooc_");
        return repository;
    }
>>>>>>> f891eae53efffc86ccdc969ae2f58a0d7395b385
}
