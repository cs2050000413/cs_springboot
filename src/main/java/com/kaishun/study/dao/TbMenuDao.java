package com.kaishun.study.dao;

import com.kaishun.study.entity.TbMenu;
import com.kaishun.study.entity.TbUser;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TbMenu)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-25 14:58:19
 */
public interface TbMenuDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbMenu queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TbMenu> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbMenu 实例对象
     * @return 对象列表
     */
    List<TbMenu> queryAll(TbMenu tbMenu);

    /**
     * 新增数据
     *
     * @param tbMenu 实例对象
     * @return 影响行数
     */
    int insert(TbMenu tbMenu);

    /**
     * 修改数据
     *
     * @param tbMenu 实例对象
     * @return 影响行数
     */
    int update(TbMenu tbMenu);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

    List<TbMenu> getMenus();

    List<TbMenu> getMenusByUserId(String userId);

    List<TbMenu> findAll();

    List<TbMenu> getMenuByName(String s);

    List<TbMenu> getMenusByRoleId(String roleId);

    List<TbMenu> findByParentNumber(String parentNumber);

    List<TbMenu> getMenusByParentNumbers(@Param(value = "parentNumbers") List<String> parentNumbers);
}