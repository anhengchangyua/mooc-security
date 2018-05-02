package com.zhy.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;

/*
 *  点击form提交表单，处理用户信息获取的逻辑 ，使用UserDetailsService接口。
 *
 */
@Component
<<<<<<< HEAD:security-demo/src/main/java/com/zhy/security/MyUserDetailService.java
public class MyUserDetailService implements UserDetailsService, SocialUserDetailsService {
=======
public class MyUserDetailService implements UserDetailsService ,SocialUserDetailsService{
>>>>>>> f891eae53efffc86ccdc969ae2f58a0d7395b385:security-demo/src/main/java/com/zhy/security/MyUserDetailService.java

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 根据用户名获取用户信息
        logger.info(" 用户名" + username);

        // 根据查找到的用户信息判断是否冻结
        return new User(username, encoder.encode("123456"), // 从数据库中获取的密码，校验交给框架来处理
                true,
                true,
                true,
                true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }

    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {

        //根据用户名获取用户信息
        logger.info(" 社交登录ID" + userId);

        // 根据查找到的用户信息判断是否冻结
        return new SocialUser(userId, encoder.encode("123456"),
                true,
                true,
                true,
                true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }

    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {

        //根据用户名获取用户信息
        logger.info(" 社交登录ID" + userId);

        // 根据查找到的用户信息判断是否冻结
        return new SocialUser(userId, encoder.encode("123456"),
                true,
                true,
                true,
                true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
