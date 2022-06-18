package com.kaishun.study.service.impl;


import com.kaishun.study.dao.TbContestWinDao;
import com.kaishun.study.entity.TbContestWin;
import com.kaishun.study.service.TbContestWinService;
import com.kaishun.study.utils.CommonUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TbContestWin)表服务实现类
 *
 */
@Service("tbContestWinService")
public class TbContestWinServiceImpl implements TbContestWinService {
    @Resource
    private TbContestWinDao tbContestWinDao;

    @Resource
    private CommonUtils commonUtils;

    @Override
    public TbContestWin queryByContestId(String contestId){
        return this.tbContestWinDao.queryByContestId(contestId);
    }
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbContestWin queryById(String id) {
        return this.tbContestWinDao.findById(id);
    }

    /**
     * 新增数据
     *
     * @return 实例对象
     */
    @Override
    public int insert(TbContestWin tbContestWin) {
        return tbContestWinDao.insert(tbContestWin);

    }

    /**
     * 修改数据
     *
     * @return 实例对象
     */
    @Override
    public int update(TbContestWin tbContestWin) {
        return this.tbContestWinDao.update(tbContestWin);

    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        return this.tbContestWinDao.deleteById(id) > 0;
    }

    @Override
    public boolean deleteByContestId(String id) {
        return this.tbContestWinDao.deleteByContestId(id) > 0;
    }

    @Override
    public List<TbContestWin> getWinList() {
        return tbContestWinDao.findAll();
    }

    @Override
    public List<TbContestWin> getContestWinByName(String name) {
        return tbContestWinDao.getContestWinByName("%"+name+"%");
    }


}