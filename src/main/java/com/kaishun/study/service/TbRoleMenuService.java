package com.kaishun.study.service;

import com.kaishun.study.entity.TbMenu;
import com.kaishun.study.entity.TbRoleMenu;
import com.kaishun.study.info.RoleMenuInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * (TbRoleMenu)表服务接口
 *
 * @author makejava
 * @since 2020-02-25 12:47:42
 */
public interface TbRoleMenuService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbRoleMenu queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TbRoleMenu> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tbRoleMenu 实例对象
     * @return 实例对象
     */
    TbRoleMenu insert(TbRoleMenu tbRoleMenu);

    /**
     * 修改数据
     *
     * @param tbRoleMenu 实例对象
     * @return 实例对象
     */
    TbRoleMenu update(TbRoleMenu tbRoleMenu);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

    List<TbRoleMenu> findMenuIdByRoleIds(List<String> roleIds);

    public TbRoleMenu findByMenuIdAndRoleId(String menuId,String roleId);

    void deleteAndInsertByRoleId(RoleMenuInfo info, HttpServletRequest request);

    List<TbRoleMenu> findByMenuIdsAndRole(List<String> collect, String roleId);
}