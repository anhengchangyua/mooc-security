package com.zhy.security.browser;

import com.zhy.security.core.properties.SecurityProperties;
import com.zhy.security.core.validate.code.ValidateCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private AuthenticationSuccessHandler imoocAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler imoocAuthenctiationFailureHandler;


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
        validateCodeFilter.setAuthenticationFailureHandler(imoocAuthenctiationFailureHandler);
        validateCodeFilter.setSecurityProperties(securityProperties);
        validateCodeFilter.afterPropertiesSet();

        //表单登录
        //设置验证码filter 在usernamepasswordAuthentication之前
        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                .loginPage("/authentication/require")//设置登录页面，跳转到一个controller方法上
                //在提交表单的时候 让security知道需要用usernamepasswordAthenticationfilter处理请求
                .loginProcessingUrl("/authentication/form")//让 usernamepasswordAthenticationfilter 知道当处理这个请求的时候,需要做的配置
                .successHandler(imoocAuthenticationSuccessHandler)
                .failureHandler(imoocAuthenctiationFailureHandler)
                .and()
                .authorizeRequests()
                .antMatchers("/authentication/require"
                        , securityProperties.getBrowser().getLoginPage(),
                        "/code/image")
                .permitAll()//访问以上请求的时候不需要认证，其他的所有需要认证
                .anyRequest()
                .authenticated()
                .and()
                .csrf()
                .disable();
    }
}
