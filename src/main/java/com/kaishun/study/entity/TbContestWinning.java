package com.kaishun.study.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbContestWinning {

    private String id;

    private String contestId;

    private String winType;

    private String remark;
}
