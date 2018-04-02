package com.zhy.security.core.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;

// 读取所有以imooc.security开头的配置
@ConfigurationProperties(prefix = "imooc.security")
public class SecurityProperties {

    // 读取imooc.security.browser
    private BrowserProperties browser = new BrowserProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }
}
