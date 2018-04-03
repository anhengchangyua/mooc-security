package com.zhy.security.core.validate.code;


import com.zhy.security.core.properties.SecurityProperties;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidateCodeBeanConfig {

    @Autowired
    SecurityProperties securityProperties;

    @Bean
//    @ConditionalOnMissingBean(name = "imageCodeGenerator")//此注解是为先在容器中找imageCodeGenerator，如果有不走
    public ValidateCodeGenerator imageCodeGenerator() {
        ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
        codeGenerator.setSecurityProperties(securityProperties);
        return codeGenerator;
    }

}
