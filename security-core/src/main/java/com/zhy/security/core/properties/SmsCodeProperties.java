package com.zhy.security.core.properties;

// 应用级默认配置
// 继续封装一个ValidateProperties
public class SmsCodeProperties {


    private int length = 4;
    private int expiredIn = 60;

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getExpiredIn() {
        return expiredIn;
    }

    public void setExpiredIn(int expiredIn) {
        this.expiredIn = expiredIn;
    }
}
