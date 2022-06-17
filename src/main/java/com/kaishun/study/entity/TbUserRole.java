package com.kaishun.study.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (TbUserRole)实体类
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
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


}