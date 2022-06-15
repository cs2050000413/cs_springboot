package com.kaishun.study.entity;

import java.io.Serializable;

/**
 * (TbMenu)实体类
 *
 * @author makejava
 * @since 2020-02-25 14:58:16
 */
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


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getParentNumber() {
        return parentNumber;
    }

    public void setParentNumber(String parentNumber) {
        this.parentNumber = parentNumber;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

}