package com.kaishun.study.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (TbMenu)实体类
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbMenu implements Serializable {
    private static final long serialVersionUID = 214241636221186516L;
    /**
    * 主键
    */
    private String id;
    /**
    * 编号
    */
    private String number;
    /**
    * 图标
    */
    private String parentNumber;
    /**
    * 名称
    */
    private String name;
    /**
    * 备注
    */
    private String remark;
    /**
    * 路径
    */
    private String url;
    
    private String createTime;
    
    private String updateTime;
    
    private String updateUser;


}