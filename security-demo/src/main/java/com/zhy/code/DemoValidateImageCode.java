package com.zhy.code;


import com.zhy.security.core.validate.code.ImageCode;
import com.zhy.security.core.validate.code.ValidateCodeGenerator;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

@Component("imageCodeGenerator")
public class DemoValidateImageCode implements ValidateCodeGenerator {
    @Override
    public ImageCode generate(ServletWebRequest request) {
        System.out.println("xxxxxxxxxxxx");

        return null;
    }
}
