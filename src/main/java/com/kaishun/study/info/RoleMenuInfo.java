package com.kaishun.study.info;

import java.util.List;

/**
 * ClassName:    RoleMenuInfo
 * Package:    com.kaishun.study.info
 * Description:
 * Datetime:    2020/4/15   15:50
 * Author:   zhoukaishun
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
public class RoleMenuInfo {

    private String roleId;

    private List<String> menuIds;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public List<String> getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(List<String> menuIds) {
        this.menuIds = menuIds;
    }
}
