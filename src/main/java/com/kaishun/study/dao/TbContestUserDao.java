package com.kaishun.study.dao;


public interface TbContestUserDao {

    int insert(String id,String contestId, String userId);

    int deleteByUserId(String userId);

    Integer findByUserId(String userId);
}
