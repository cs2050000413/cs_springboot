package com.kaishun.study.Result;

import java.util.List;

/**
 * ClassName:    RoleMenuResult
 * Package:    com.kaishun.study.Result
 * Description:
 * Datetime:    2020/4/15   13:36
 * Author:   zhoukaishun
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
public class RoleMenuResult {

    private List<MenuTreeResult> list;

    public List<MenuTreeResult> getList() {
        return list;
    }

    public void setList(List<MenuTreeResult> list) {
        this.list = list;
    }
}
