package com.zhy.security.core.social.qq.connect;

import com.zhy.security.core.social.qq.api.QQ;
import com.zhy.security.core.social.qq.api.QQImpl;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;


/**
 * 服务提供商相关 提供 template请求 api
 */

public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQ> {

    private String appId;
    private static final String URL_AUTHORIZE = "https://graph.qq.com/oauth2.0/authorize";

    private static final String URL_ACCESS_TOKEN = "https://graph.qq.com/oauth2.0/token";

    //appId,appSecret QQ申请的

    public QQServiceProvider(String appId, String appSecret) {
        super(new OAuth2Template(appId, appSecret, URL_AUTHORIZE, URL_ACCESS_TOKEN));
        this.appId = appId;
    }

    @Override
    public QQ getApi(String accessToken) {
        return new QQImpl(accessToken, appId);
    }
}
