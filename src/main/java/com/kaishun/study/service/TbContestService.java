package com.kaishun.study.service;

import com.kaishun.study.Result.MenuTreeResult;
import com.kaishun.study.dao.TbContestDao;
import com.kaishun.study.entity.TbContest;
import com.kaishun.study.entity.TbMenu;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * (TbContest)表服务接口
 *
 */
public interface TbContestService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbContest queryById(String id);
    /**
     * 新增数据
     *
     * @return 实例对象
     */
    int insert(TbContest tbContest);

    /**
     * 修改数据
     *
     * @return 实例对象
     */
    int update(TbContest tbContest);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);


    List<TbContest> getList();

    List<TbContest> getContestByName(String name);

}