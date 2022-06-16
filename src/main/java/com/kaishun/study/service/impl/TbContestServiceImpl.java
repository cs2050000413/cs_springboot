package com.kaishun.study.service.impl;

import com.kaishun.study.Result.MenuTreeResult;
import com.kaishun.study.config.JWTConfig;
import com.kaishun.study.dao.TbContestDao;
import com.kaishun.study.dao.TbMenuDao;
import com.kaishun.study.entity.TbContest;
import com.kaishun.study.entity.TbMenu;
import com.kaishun.study.entity.TbRoleMenu;
import com.kaishun.study.service.TbContestService;
import com.kaishun.study.service.TbMenuService;
import com.kaishun.study.service.TbRoleMenuService;
import com.kaishun.study.utils.CommonUtils;
import com.kaishun.study.utils.JwtTokenUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * (TbContest)表服务实现类
 *
 */
@Service("tbContestService")
public class TbContestServiceImpl implements TbContestService {
    @Resource
    private TbContestDao tbContestDao;

    @Resource
    private CommonUtils commonUtils;


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbContest queryById(String id) {
        return this.tbContestDao.queryById(id);
    }

    /**
     * 新增数据
     *
     * @return 实例对象
     */
    @Override
    public int insert(TbContest tbContest) {
        return tbContestDao.insert(tbContest);

    }

    /**
     * 修改数据
     *
     * @return 实例对象
     */
    @Override
    public int update(TbContest tbContest) {
        return this.tbContestDao.update(tbContest);

    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.tbContestDao.deleteById(id) > 0;
    }


    @Override
    public List<TbContest> getList() {
        return tbContestDao.findAll();
    }

    @Override
    public List<TbContest> getContestByName(String name) {
        return tbContestDao.getContestByName("%"+name+"%");
    }


}