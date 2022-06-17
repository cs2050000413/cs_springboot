package com.kaishun.study.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbContest {

    private String id;

    private String contestName;

    private String type;

    private String contestTime;

    private String remark;

}

