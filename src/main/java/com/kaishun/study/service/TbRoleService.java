package com.kaishun.study.service;

import com.kaishun.study.Result.RoleMenuResult;
import com.kaishun.study.entity.TbRole;
import com.kaishun.study.utils.PageRequest;
import com.kaishun.study.utils.PageResult;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * (TbRole)表服务接口
 *
 * @author makejava
 * @since 2020-02-25 12:47:32
 */
public interface TbRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbRole queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TbRole> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tbRole 实例对象
     * @return 实例对象
     */
    TbRole insert(TbRole tbRole, HttpServletRequest request);

    /**
     * 修改数据
     *
     * @param tbRole 实例对象
     * @return 实例对象
     */
    TbRole update(TbRole tbRole,  HttpServletRequest request);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

    boolean checkCodeRight(String checkCode);

    List<TbRole> getRoleList();

    String getCodeId(String checkcode);
}