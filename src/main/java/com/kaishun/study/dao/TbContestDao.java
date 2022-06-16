package com.kaishun.study.dao;

import com.kaishun.study.entity.TbContest;

import java.util.List;

public interface TbContestDao {

    List<TbContest> findAll();

    TbContest findById(String id);

    List<TbContest> queryAll(TbContest tbContest);

    int deleteById(String id);

    int insert(TbContest tbContest);

    int update(TbContest tbContest);

    List<TbContest> getContestByName(String name);
}
