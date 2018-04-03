package com.zhy.security.core.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;

// 读取所有以imooc.security开头的配置
@ConfigurationProperties(prefix = "imooc.security")
public class SecurityProperties {

    // 读取imooc.security.browser
    private BrowserProperties browser = new BrowserProperties();

    public ValidateCodeProperties getCode() {
        return code;
    }

    public void setCode(ValidateCodeProperties code) {
        this.code = code;
    }

    private ValidateCodeProperties code = new ValidateCodeProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }
}
