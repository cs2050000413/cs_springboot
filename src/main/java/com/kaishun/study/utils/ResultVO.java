package com.kaishun.study.utils;

import lombok.Data;

/**
 * ClassName:    ResultVO
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Data
public class ResultVO<T> {
    /**
     * 返回码
     */
    private Integer code;
    /**
     * 返回信息
     */
    private String message;
    /**
     * 状态
     */
    private String status;
    /**
     * 条数
     */
    private Integer count;
    /**
     * 返回值
     */
    private T data;
    /**
     * 跳转url
     */
    private String url;
}
