package com.zhy.security.core.social.qq.connect;

import com.zhy.security.core.social.qq.api.QQ;
import com.zhy.security.core.social.qq.api.QQUserInfo;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

public class QQAdapter implements ApiAdapter<QQ> {

    //测试api是否可用
    @Override
    public boolean test(QQ qq) {
        return true;
    }

    @Override
    public void setConnectionValues(QQ qq, ConnectionValues connectionValues) {
        //connectionValues 包含connection需要的数据项
        QQUserInfo userInfo = qq.getUserInfo();
        connectionValues.setDisplayName(userInfo.getNickname());
        connectionValues.setImageUrl(userInfo.getFigureurl());
        connectionValues.setProfileUrl(null);//主页地址
        connectionValues.setProviderUserId(userInfo.getOpenId());

    }

    @Override
    public UserProfile fetchUserProfile(QQ qq) {
        return null;
    }

    //在微博这种可以使用----do nothing
    @Override
    public void updateStatus(QQ qq, String s) {

    }
}
