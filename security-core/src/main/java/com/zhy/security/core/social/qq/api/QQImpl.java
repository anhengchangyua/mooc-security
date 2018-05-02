package com.zhy.security.core.social.qq.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

//    执行第六步 获取用户信息 需要有令牌token
//    private final String accessToken;  令牌token
//    private RestTemplate restTemplate; 发送http请求

//    所有的api都继承了AbstractOAuth2ApiBinding


public class QQImpl extends AbstractOAuth2ApiBinding implements QQ {
    private static final String URL_GET_OPENID = "https://graph.qq.com/oauth2.0/me?access_token=%s";

    private static final String URL_GET_USERINFO = "https://graph.qq.com/user/get_user_info?oauth_consumer_key=%s&openid=%s";

    private ObjectMapper objectMapper = new ObjectMapper();
    // qq 所需要传递的参数
    private String openId;
    private String appId;

    public QQImpl(String accessToken, String appId) {
        // QQ 所需的token需要在请求体中， 而默认为header中
        // 自动为请求添加token参数
        super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
        this.appId = appId;

        // String.format 替换掉 URL_GET_OPENID %S
        String url = String.format(URL_GET_OPENID, accessToken);
        // 获取用户信息
        String result = getRestTemplate().getForObject(url, String.class);
        System.out.println(result);

        // 读取openId
        this.openId = StringUtils.substringBetween(result, "\"openid\":\"", "\"}");
    }

    //获取用户信息
    @Override
    public QQUserInfo getUserInfo() {

        String url = String.format(URL_GET_USERINFO, appId, openId);
        String result = getRestTemplate().getForObject(url, String.class);

        System.out.println(result);

        QQUserInfo userInfo = null;
        try {

            userInfo = objectMapper.readValue(result, QQUserInfo.class);
            userInfo.setOpenId(openId);
            return userInfo;
        } catch (Exception e) {
            throw new RuntimeException("获取用户信息失败", e);
        }

    }
}
