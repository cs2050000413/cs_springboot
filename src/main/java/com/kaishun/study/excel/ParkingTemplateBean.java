package com.kaishun.study.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @Package: com.youmatech.zhsq.operation.excel.bean
 * @ClassName: ParkingTemplateBean
 * @Author: zhoukaishun
 * @CreateTime: 2022/1/13 9:27
 * @Description:
 */
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ParkingTemplateBean {

    /**
     * 车位号
     */
    @ExcelProperty("车位号")
    private String parkingSpaceNumber;
    /**
     * 车位类型:
     * 0-地面；
     * 1-地库；
     */
    @ExcelProperty("车位类型")
    private String parkingType;
    /**
     * 运营模式：
     * 0-销售；
     * 1-租赁；
     */
    @ExcelProperty("运营模式")
    private String operationMode;
    /**
     * 车位状态：
     * 0-闲置；
     * 1-租赁中；
     * 2-已出售；
     * 3-租赁过期
     */
    @ExcelProperty("车位状态")
    private String parkingStatus;
    /**
     * 车位地址
     */
    @ExcelProperty("车位地址")
    private String parkingAddress;

}
