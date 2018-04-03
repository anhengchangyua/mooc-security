package com.zhy.security.core.properties;

// 应用级默认配置
// 继续封装一个ValidateProperties
public class ImageCodeProperties {

    private int width = 67;
    private int height = 23;

    private int length = 4;
    private int expiredIn = 60;


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
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
