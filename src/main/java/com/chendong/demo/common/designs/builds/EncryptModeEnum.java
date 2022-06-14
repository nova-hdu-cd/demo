package com.chendong.demo.common.designs.builds;

public enum EncryptModeEnum {

    /**
     * 默认不加密
     */
    DEFAULT("default"),

    /**
     * 处理json序列化
     */
    ENCODESTR("enCodeStr"),

    /**
     * base64加密
     */
    BASE64("base64");

    private String encryptMode;

    EncryptModeEnum(String encryptMode) {
        this.encryptMode = encryptMode;
    }

    public String getEncryptMode() {
        return encryptMode;
    }

    /**
     * 获取加密方式
     *
     * @param encryptMode
     * @return
     */
    public static EncryptModeEnum queryEncryptMode(String encryptMode) {
        for (EncryptModeEnum value : EncryptModeEnum.values()) {
            if (value.getEncryptMode().equals(encryptMode)) {
                return value;
            }
        }
        return EncryptModeEnum.DEFAULT;
    }

}
