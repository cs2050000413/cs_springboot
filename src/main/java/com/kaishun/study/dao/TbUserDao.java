package com.kaishun.study.dao;

import com.kaishun.study.entity.TbUser;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TbUser)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-14 12:54:28
 */
public interface TbUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbUser queryById(String id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TbUser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tbUser 实例对象
     * @return 对象列表
     */
    List<TbUser> queryAll(TbUser tbUser);

    /**
     * 新增数据
     *
     * @param tbUser 实例对象
     * @return 影响行数
     */
    int insert(TbUser tbUser);

    /**
     * 修改数据
     *
     * @param tbUser 实例对象
     * @return 影响行数
     */
    int update(TbUser tbUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);
    /**
     * @description 获取用户列表
     * @author zhoukaishun
     * @date 2020/2/14 13:12
     */
    List<TbUser> findAll();

    List<TbUser> findStudent();

    List<TbUser> findTeacher();

    TbUser login(TbUser tbUser);

    void updatePasswordByPhone(@Param("phone") String phone,@Param("password") String password);

    TbUser findTbUserByPhone(String phone);

    List<TbUser> getUserByName(String name);

    TbUser queryByUserName(String userName);

    /**
     *
     * @return
     */
    List<Integer> getCount();
}