package com.kaishun.study.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbContestWin {

    private String id;

    private String contestId;

    private String contestName;

    private String contestType;

    private String contestTime;

    private String winType;

    private String winTime;

    private String remark;

}

