package com.kaishun.study.controller;

import com.kaishun.study.Result.MenuTreeResult;
import com.kaishun.study.Result.RoleMenuResult;
import com.kaishun.study.entity.TbMenu;
import com.kaishun.study.entity.TbRoleMenu;
import com.kaishun.study.entity.TbUser;
import com.kaishun.study.entity.TbUserRole;
import com.kaishun.study.service.*;
import com.kaishun.study.utils.PageRequest;
import com.kaishun.study.utils.PageResult;
import com.kaishun.study.utils.ResultVO;
import com.kaishun.study.utils.ResultVOUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * (TbMenu)表控制层
 *
 * @author makejava
 * @since 2020-02-25 14:58:20
 */
@RestController
@RequestMapping("tbMenu")
public class TbMenuController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 服务对象
     */
    @Resource
    private TbMenuService tbMenuService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TbMenu selectOne(String id) {
        return this.tbMenuService.queryById(id);
    }
/*******************************代码开始***************************************/

    @GetMapping("getMenus")
    public ResultVO getMenus() {
        List<TbMenu> tbMenuList = tbMenuService.getMenusByUserId();
        return ResultVOUtil.success(tbMenuList);
    }

    @GetMapping("getList")
    public ResultVO getList(){
        logger.info("获取菜单列表");
        List<TbMenu> list = tbMenuService.getList();
        return ResultVOUtil.success(list);
    }

    @PostMapping("/setMenu")
    public ResultVO addMenu(HttpServletRequest request,TbMenu tbMenu){
        logger.info("新增菜单");
        tbMenuService.insert(tbMenu,request);
        return ResultVOUtil.success();
    }

    @PostMapping("/updateMenu")
    public ResultVO updateMenu(HttpServletRequest request,TbMenu tbMenu){
        logger.info("更新菜单");
        tbMenuService.update(tbMenu,request);
        return ResultVOUtil.success();
    }

    @GetMapping("/getMenuByName")
    public ResultVO getMenuByName(String name){
        List<TbMenu> list = tbMenuService.getMenuByName(name);
        return ResultVOUtil.success(list);
    }

    @DeleteMapping("/delete")
    public ResultVO deleteById(String id){
        logger.info("删除菜单");
        tbMenuService.deleteById(id);
        return ResultVOUtil.success();
    }

    @PostMapping("/getPermission")
    public ResultVO getPermission(String id){
        List<MenuTreeResult> list = tbMenuService.getMenusByRoleId(id);
        return ResultVOUtil.success(list);
    }

}