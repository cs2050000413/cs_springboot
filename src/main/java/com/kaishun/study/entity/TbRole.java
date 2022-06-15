package com.kaishun.study.entity;

import java.io.Serializable;

/**
 * (TbRole)实体类
 */
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


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCheckCode() { return checkCode; }

    public void setCheckCode(String checkCode) { this.checkCode = checkCode; }

}