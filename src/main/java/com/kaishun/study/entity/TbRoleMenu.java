package com.kaishun.study.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (TbRoleMenu)实体类
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbRoleMenu implements Serializable {
    private static final long serialVersionUID = 971562622076456815L;
    /**
    * 主键
    */
    private String id;
    /**
    * 角色id
    */
    private String roleId;
    /**
    * 菜单id
    */
    private String menuId;
    
    private String createTime;
    
    private String updateTime;
    
    private String updateUser;

}