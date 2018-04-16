package com.zhy.security.core.validate.code;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

public class ValidateCode {


    private String code;

    private LocalDateTime expireTime;

    // 构造的时候传递一个过期的秒数
    public ValidateCode(String code, int expireIn) {
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    //是否已经过期
    public boolean isExpried() {
        return LocalDateTime.now().isAfter(expireTime);
    }

    public ValidateCode(String code, LocalDateTime expireTime) {
        this.code = code;
        this.expireTime = expireTime;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }
}
