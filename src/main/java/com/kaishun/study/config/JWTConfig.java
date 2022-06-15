package com.kaishun.study.config;

/**
 * @ClassName: JWT
 * @Package: com.runwel.common.config
 * @Description:
 * @Datetime: 2020/7/29   15:39
 * @author: kaishun.zhou
 */
public class JWTConfig {
    //  代表这个JWT的接收对象,存入jwtconfig
    //  add by kaishun.zhou
    public static final String clientId = "YWRkJTIwYnklMjBrYWlzaHVuLnpob3U=";
    //密钥, 经过Base64加密, 可自行替换
    public static final String base64Secret = "WVdSa0pUSXdZbmtsTWpCcllXbHphSFZ1TG5wb2IzVSUzRA==";
    //JWT的签发主体，存入issuer
    public static final String name = "restapiuser";
    //过期时间，毫秒
    public static final int expiresSecond = 3600000 * 24;
}
