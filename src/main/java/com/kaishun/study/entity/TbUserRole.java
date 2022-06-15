package com.kaishun.study.entity;

import java.io.Serializable;

/**
 * (TbUserRole)实体类
 *
 * @author makejava
 * @since 2020-02-26 09:06:48
 */
public class TbUserRole implements Serializable {
    private static final long serialVersionUID = 662798498526099853L;
    /**
    * 主键
    */
    private String id;
    /**
    * 角色id
    */
    private String roleId;
    /**
    * 用户id
    */
    private String userId;
    /**
    * 创建时间
    */
    private String createTime;
    /**
    * 最后修改时间
    */
    private String updateTime;
    /**
    * 最后修改人
    */
    private String updateUser;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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