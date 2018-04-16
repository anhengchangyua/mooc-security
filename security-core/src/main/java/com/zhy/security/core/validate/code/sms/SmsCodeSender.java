package com.zhy.security.core.validate.code.sms;

public interface SmsCodeSender {
    void sender(String moblie, String code);
}
