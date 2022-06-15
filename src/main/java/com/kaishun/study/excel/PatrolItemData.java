package com.kaishun.study.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Package: com.kaishun.study.excel
 * @ClassName: PatrolItemData
 * @Author: zhoukaishun
 * @CreateTime: 2021/12/8 18:09
 * @Description:
 */
@Data
@EqualsAndHashCode
public class PatrolItemData {

    /**
     * 字段顺序与excel一致，或者使用注解指定列
     */
    @ExcelProperty("title")
    private String title;

    @ExcelProperty("name")
    private String name;

    @ExcelProperty("item")
    private String item;

    @ExcelProperty("detail")
    private String detail;

    @ExcelProperty("checkMethod")
    private String checkMethod;

    @ExcelProperty("score")
    private String score;


}
