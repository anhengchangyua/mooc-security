package com.zhy.security.core.validate.code.sms;

public class DefaultSmsCodeSender implements SmsCodeSender {
    @Override
    public void sender(String mobile, String code) {
        System.out.println("向手机：" + mobile + "验证码：" + code);
    }
}
