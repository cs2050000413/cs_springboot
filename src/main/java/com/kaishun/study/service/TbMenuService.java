package com.kaishun.study.service;

import com.kaishun.study.Result.MenuTreeResult;
import com.kaishun.study.entity.TbMenu;
import com.kaishun.study.utils.PageRequest;
import com.kaishun.study.utils.PageResult;
import com.kaishun.study.utils.ResultVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * (TbMenu)表服务接口
 *
 * @author makejava
 * @since 2020-02-25 14:58:19
 */
public interface TbMenuService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbMenu queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TbMenu> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tbMenu 实例对象
     * @return 实例对象
     */
    boolean insert(TbMenu tbMenu,HttpServletRequest request);

    /**
     * 修改数据
     *
     * @param tbMenu 实例对象
     * @return 实例对象
     */
    TbMenu update(TbMenu tbMenu,HttpServletRequest request);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

    List<TbMenu> getMenus();

    List<TbMenu> getMenusByUserId();

    List<TbMenu> getList();

    List<TbMenu> getMenuByName(String name);

    List<MenuTreeResult> getMenusByRoleId(String id);
}