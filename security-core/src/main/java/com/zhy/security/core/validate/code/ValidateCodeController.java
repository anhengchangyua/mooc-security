package com.zhy.security.core.validate.code;


import com.zhy.security.core.validate.code.sms.DefaultSmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RestController
public class ValidateCodeController {

    @Autowired
    ValidateCodeGenerator imageCodeGenerate;

    @Autowired
    ValidateCodeGenerator smsCodeGenerate;

    @Autowired
    DefaultSmsCodeSender smsCodeSender;


    public static final String SESSION_KEY = "SESSION_KEY_IMAGE_CODE";

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @GetMapping("/code/image")
    public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ImageCode imageCode = (ImageCode) imageCodeGenerate.generate(new ServletWebRequest(request));
        //将随机数存到session中
        sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_KEY, imageCode);
        ImageIO.write(imageCode.getImage(), "JPEG", response.getOutputStream());//写到输出流中
    }

    @GetMapping("/code/sms")
    public void createSmsCode(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletRequestBindingException {
        ValidateCode smsCode = smsCodeGenerate.generate(new ServletWebRequest(request));
        //将随机数存到session中
        sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_KEY, smsCode);

        String mobile = ServletRequestUtils.getRequiredStringParameter(request, "mobile");

        //短信服务商来发送短信
        smsCodeSender.sender(mobile, smsCode.getCode());
    }


}
