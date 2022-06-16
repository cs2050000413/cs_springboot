package com.kaishun.study.controller;

import com.kaishun.study.entity.TbContest;
import com.kaishun.study.service.TbContestService;
import com.kaishun.study.service.TbContestWinService;
import com.kaishun.study.utils.CommonUtils;
import com.kaishun.study.utils.DateUtil;
import com.kaishun.study.utils.ResultVO;
import com.kaishun.study.utils.ResultVOUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tbContest")
@Slf4j
public class TbContestController {

    @Autowired
    TbContestWinService tbContestWinService;

    @Autowired
    TbContestService tbContestService;

    @PostMapping("/getContest")
    public ResultVO getContestList() {
        log.info("获取所有竞赛信息");
        List<TbContest> list = tbContestService.getList();
        return ResultVOUtil.success(list);
    }

    @PostMapping("/getContestByName")
    @ApiOperation(value = "根据竞赛名称查询竞赛集合")
    public ResultVO<List<TbContest>> getContestByName(String name) {
        List<TbContest> list = tbContestService.getContestByName(name);
        return ResultVOUtil.success(list);
    }

    @DeleteMapping("/delete")
    public ResultVO deleteContestById(String id) {
        log.info("删除用户，id={}", id);
        tbContestService.deleteById(id);
        if(tbContestWinService.deleteByContestId(id))
            return ResultVOUtil.success();
        else
            return ResultVOUtil.error(0,"删除失败！");
    }

    @PostMapping("/setContest")
    public ResultVO addContest(TbContest tbContest) {
        log.info("新增竞赛信息");
        if(tbContest.getId().equals("自动生成"))
            tbContest.setId(new CommonUtils().getUUID32());
        tbContestService.insert(tbContest);
        return ResultVOUtil.success();
    }

    @PostMapping("/updateContest")
    public ResultVO updateUser(TbContest contest) {
        log.info("更新竞赛信息");
        tbContestService.update(contest);
        return ResultVOUtil.success();
    }
}
