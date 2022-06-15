package com.kaishun.study.dao;

import com.kaishun.study.entity.TbRoleMenu;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TbRoleMenu)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-25 12:47:42
 */
public interface TbRoleMenuDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbRoleMenu queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TbRoleMenu> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbRoleMenu 实例对象
     * @return 对象列表
     */
    List<TbRoleMenu> queryAll(TbRoleMenu tbRoleMenu);

    /**
     * 新增数据
     *
     * @param tbRoleMenu 实例对象
     * @return 影响行数
     */
    int insert(TbRoleMenu tbRoleMenu);

    /**
     * 修改数据
     *
     * @param tbRoleMenu 实例对象
     * @return 影响行数
     */
    int update(TbRoleMenu tbRoleMenu);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

    List<TbRoleMenu> findMenuIdByRoleIds(@Param("roleIds") List<String> roleIds);


    TbRoleMenu findByMenuIdAndRoleId(@Param("menuId") String menuId, @Param("roleId") String roleId);

    void deleteByRoleId(String roleId);

    List<TbRoleMenu> findByMenuIdsAndRole(@Param("menuIds")List<String> menuIds,@Param("roleId")String roleId);
}