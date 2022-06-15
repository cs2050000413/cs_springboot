package com.kaishun.study.entity;

import com.kaishun.study.validator.Password;
import com.kaishun.study.validator.Phone;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * (TbUser)实体类
 *
 * @author makejava
 * @since 2020-03-13 16:45:24
 */
@ApiModel
public class TbUser implements Serializable {
    private static final long serialVersionUID = -88598328571083439L;
    /**
    * id
    */
    @ApiModelProperty("主键")
    private String id;
    /**
    * 用户名
    */
    @ApiModelProperty("用户名")
    private String userName;
    /**
    * 密码
    */
    @ApiModelProperty("密码")
    private String userPassword;
    /**
    * 手机号
    */
    @Phone
    @ApiModelProperty("手机号")
    private String phone;
    /**
    * 性别
    */
    private String sex;
    /**
    * 年龄
    */
    @ApiModelProperty("年龄")
    private Integer age;
    /**
    * 创建时间
    */
    private String createTime;
    /**
    * 修改时间
    */
    private String updateTime;
    /**
     * 修改者
     */
    private String updateUser;

    @Override
    public String toString() {
        return "TbUser{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", phone='" + phone + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", updateUser='" + updateUser + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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