package com.kaishun.study.entity;

import com.kaishun.study.validator.Password;
import com.kaishun.study.validator.Phone;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (TbUser)实体类
 *
 */
@ApiModel
@Data
@AllArgsConstructor
@NoArgsConstructor
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
     * 姓名
     */
    @ApiModelProperty("姓名")
    private String pname;
    /**
    * 密码
    */
    @Password
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

    //角色ID
    private String roleId;

    //角色
    private String role;
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

}