package com.kaishun.study.controller;

import com.kaishun.study.entity.TbContest;
import com.kaishun.study.entity.TbContestWin;
import com.kaishun.study.service.TbContestService;
import com.kaishun.study.service.TbContestWinService;
import com.kaishun.study.utils.CommonUtils;
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
@RequestMapping("tbContestWin")
@Slf4j
public class TbContestWinController {

    @Autowired
    TbContestWinService tbContestWinService;

    @Autowired
    TbContestService tbContestService;

    @PostMapping("/getContestWin")
    public ResultVO getWinList() {
        log.info("获取所有竞赛信息");
        List<TbContestWin> list = tbContestWinService.getWinList();
        return ResultVOUtil.success(list);
    }

    @PostMapping("/getContestWinByName")
    @ApiOperation(value = "根据竞赛名称查询竞赛获奖集合")
    public ResultVO<List<TbContest>> getContestByName(String name) {
        List<TbContestWin> list = tbContestWinService.getContestWinByName(name);
        return ResultVOUtil.success(list);
    }

    @DeleteMapping("/delete")
    public ResultVO deleteContestWinById(String id) {
        log.info("删除获奖竞赛，id={}", id);
        tbContestWinService.deleteById(id);
        return ResultVOUtil.success();
    }

    @DeleteMapping("/deleteByCId")
    public ResultVO deleteContestWinByCId(String id) {
        log.info("删除获奖竞赛，id={}", id);
        if(tbContestWinService.deleteByContestId(id))
            return ResultVOUtil.success();
        else
            return ResultVOUtil.error(0,"删除失败！");
    }

    @PostMapping("/setContestWin")
    public ResultVO addContestWin(TbContestWin tbContestWin) {
        log.info("新增竞赛获奖信息");
        try {
            if (tbContestService.queryById(tbContestWin.getContestId()) == null)
                return ResultVOUtil.error(0,"竞赛不存在！");
        }catch (Exception e){
            return ResultVOUtil.error(0,e.toString());
        }
        if(tbContestWin.getId().equals("自动生成"))
            tbContestWin.setId(new CommonUtils().getUUID32());
        tbContestWinService.insert(tbContestWin);
        return ResultVOUtil.success();
    }

    @PostMapping("/updateContestWin")
    public ResultVO updateUser(TbContestWin contestWin) {
        log.info("更新竞赛获奖信息");
        tbContestWinService.update(contestWin);
        return ResultVOUtil.success();
    }
}
