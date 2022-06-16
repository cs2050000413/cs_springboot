package com.kaishun.study.dao;

import com.kaishun.study.entity.TbContest;
import com.kaishun.study.entity.TbContestWin;

import java.util.List;

public interface TbContestWinDao {

    List<TbContestWin> findAll();

    TbContestWin findById(String id);

    List<TbContestWin> queryAll(TbContestWin tbContestWin);

    int deleteById(String id);

    int deleteByContestId(String id);

    int insert(TbContestWin tbContestWin);

    int update(TbContestWin tbContestWin);

    List<TbContestWin> getContestWinByName(String name);
}
