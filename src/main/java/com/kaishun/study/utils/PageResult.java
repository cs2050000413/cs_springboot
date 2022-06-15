package com.kaishun.study.utils;

import lombok.Data;

import java.util.List;

/**
 * ClassName:    PageResult
 * Package:    com.kaishun.study.utils
 * Description:
 * Datetime:    2020/2/14   13:07
 * Author:   zhoukaishun
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Data
public class PageResult {

    /**
     * 当前页码
     */
    private Integer pageNum;
    /**
     * 每页数量
     */
    private Integer pageSize;
    /**
     * 记录总数
     */
    private long totalSize;
    /**
     * 页码总数
     */
    private Integer totalPages;
    /**
     * 数据模型
     */
    private List<?> content;
}
