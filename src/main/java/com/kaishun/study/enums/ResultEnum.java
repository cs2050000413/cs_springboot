package com.kaishun.study.enums;

import lombok.Getter;

/**
 * ClassName:    ResultEnum
 * Package:    com.kaishun.study.enums
 * Description:
 * Datetime:    2020/2/14   13:18
 * Author:   zhoukaishun
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Getter
public enum ResultEnum implements CodeEnum {

    SUCCESS(0, "成功"),

    ParamsInvalid(1,"参数无效"),

    FILE_IS_EMPTY(2,"文件不能为空"),

    LOGIN_ERROR(1001,"用户名或者密码错误"),

    PHONE_ERROR(1002,"非法手机号码"),

    PHONE_CODE_ERROR(1003,"验证码与手机号不匹配"),

    PHONE_NOT_CODE_ERROR(1004,"手机号暂无验证码"),

    PHONE_NOT_BIND_USER(1005,"该手机号无绑定用户"),

    PHONE_IS_USER(1006,"该手机号已注册"),

    USERNAME_IS_USER(1007,"该用户名已被占用"),

    ILLEGAL_USERS(100, "非法用户"),

    SERVER_ERROR(500, "服务器错误"),

    UNKNOWN_ERROR(900, "未知错误"),


    PERMISSION_TOKEN_EXPIRED(401,"token过期"),

    PERMISSION_TOKEN_INVALID(402,"token解析异常"),

    PERMISSION_SIGNATURE_ERROR(403,"签名失败"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
