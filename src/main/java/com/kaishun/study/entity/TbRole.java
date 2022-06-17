package com.kaishun.study.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (TbRole)实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbRole implements Serializable {
    private static final long serialVersionUID = 668763132481364075L;
    /**
    * 主键id
    */
    private String id;
    /**
    * 角色名称
    */
    private String name;
    /**
    * 备注
    */
    private String remark;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 校验码
     */
    private String checkCode;


}