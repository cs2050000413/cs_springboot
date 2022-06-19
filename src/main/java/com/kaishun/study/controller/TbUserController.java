package com.kaishun.study.controller;

import com.kaishun.study.entity.TbUser;
import com.kaishun.study.enums.ResultEnum;
import com.kaishun.study.service.TbRoleService;
import com.kaishun.study.service.TbUserRoleService;
import com.kaishun.study.service.TbUserService;
import com.kaishun.study.utils.*;
import com.kaishun.study.validator.JwtIgnore;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * (TbUser)表控制层
 *
 * @author makejava
 * @since 2020-02-14 12:54:29
 */
@RestController
@RequestMapping("tbUser")
@Slf4j
public class TbUserController {
    /**
     * 服务对象
     */
    @Resource
    private TbUserService tbUserService;

    @Resource
    private TbUserRoleService tbUserRoleService;

    @Resource
    private TbRoleService tbRoleService;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    @ApiOperation("根据id查询单个用户")
    public TbUser selectOne(String id) {
        return this.tbUserService.queryById(id);
    }

    @PostMapping("/getList")
    public ResultVO getUserList() {
        log.info("获取所有用户信息");
        List<TbUser> list = tbUserService.getUserList();
        return ResultVOUtil.success(list);
    }
    @PostMapping("/getPerson")
    public ResultVO getPersonList(String contestId){
        log.info("获取参赛人员信息");
        List<TbUser> list = tbUserService.getUserByContestId(contestId);
        return ResultVOUtil.success(list);
    }

    @PostMapping("/getStudent")
    public ResultVO getStudentList() {
        log.info("获取所有学生信息");
        List<TbUser> list = tbUserService.getStudentList();
        return ResultVOUtil.success(list);
    }

    @PostMapping("/getTeacher")
    public ResultVO getTeacherList() {
        log.info("获取所有教师信息");
        List<TbUser> list = tbUserService.getTeacherList();
        return ResultVOUtil.success(list);
    }

    @PostMapping("/getUserByName")
    @ApiOperation(value = "根据用户名称查询用户集合")
    public ResultVO<List<TbUser>> getUserByName(String name) {
        List<TbUser> list = tbUserService.getUserByName(name);
        return ResultVOUtil.success(list);
    }

    @PostMapping("/addContestUser")
    public ResultVO addContestUser(String cid,String id){
        log.info("添加竞赛用户");
        if(tbUserService.queryById(id)==null)
            return ResultVOUtil.error(0,"用户不存在！");
        if(tbUserService.findContestUserByUserId(id,cid)==1)
            return ResultVOUtil.error(0,"用户已参赛！不可重复添加！");
        if(tbUserService.addContestUser(cid,id)==1)
            return ResultVOUtil.success();
        else
            return ResultVOUtil.error(0,"添加失败！");
    }

    @DeleteMapping("/deleteContestUser")
    public ResultVO deleteContestUserById(String id) {
        log.info("删除竞赛用户，id={}", id);
        if(tbUserService.deleteContestUser(id)==1)
            return ResultVOUtil.success();
        else
            return ResultVOUtil.error(0,"删除失败！");
    }

    @DeleteMapping("/delete")
    public ResultVO deleteUserById(String id) {
        log.info("删除用户，id={}", id);
//        if(tbUserService.findContestUserByUserId(id)==1)
//            return ResultVOUtil.error(0,"用户存在参与竞赛，请先退出竞赛再删除！");
        tbUserService.deleteById(id);
        if(tbUserRoleService.deleteById(tbUserRoleService.findRoleByUserId(id).getId()))
            return ResultVOUtil.success();
        else
            return ResultVOUtil.error(0,"删除失败！");
    }


    @JwtIgnore
    @PostMapping("/registerUser")
    @ApiOperation("用户注册")
    public ResultVO register(@Valid TbUser user,@Valid String checkCode) {
        if(!tbRoleService.checkCodeRight(checkCode))
            return ResultVOUtil.error(0,"校验码错误！");
        tbUserService.register(user, checkCode);
        return ResultVOUtil.success();
    }

//    @JwtIgnore
//    @PostMapping("/forgetPassword")
//    public ResultVO forgetPassword(@Valid ForgetInfo info) {
//        log.info("忘记密码");
//        return tbUserService.forgetPassword(info);
//    }

    @PostMapping("/setUser")
    public ResultVO addUser(@Valid TbUser user,@Valid String roleId) {
        log.info("新增用户");
        if(roleId==null)
            return ResultVOUtil.error(0,"权限id为空！");
        try{
            tbRoleService.queryById(roleId).getName();
        }catch(NullPointerException e){
            return ResultVOUtil.error(0,"权限id不存在！");
        }
        if(user.getUserPassword()==null)
            user.setUserPassword(StrToMd5.Md5("123456"));//设置默认密码123456
        tbUserService.addUser(user,roleId);
        return ResultVOUtil.success();
    }

    @PostMapping("/updateUser")
    public ResultVO updateUser(HttpServletRequest request,TbUser user) {
        log.info("更新用户");
        tbUserService.update(user, request);
        return ResultVOUtil.success();
    }

    @JwtIgnore
    @PostMapping("/login")
    public ResultVO login(HttpServletResponse response, TbUser tbUser) {
        log.info("登录");
        String token = tbUserService.login(response, tbUser);
        if (token != null) {
            return ResultVOUtil.loginSuccess(token);
        } else {
            return ResultVOUtil.error(ResultEnum.LOGIN_ERROR);
        }
    }

    @PostMapping("/logout")
    public ResultVO postLogout() {
        return ResultVOUtil.success();
    }

    @PostMapping("/info")
    public ResultVO getUserInfo(HttpServletRequest request) {
        log.info("通过token获取用户基本信息");
        TbUser tbUser = tbUserService.getUserInfo(request);
        return ResultVOUtil.success(tbUser);
    }

//    @JwtIgnore
//    @GetMapping("/threadLocalTest")
//    public String threadLocalTest(Integer number){
//        if(threadLocalTest.get() == null){
//            threadLocalTest.set(number);
//            threadLocalTest2.set(number+"str");
//        }
//        Integer result = threadLocalTest.get();
//        String result2 = threadLocalTest2.get();
//        //一定要remove
//        threadLocalTest.remove();
//        threadLocalTest2.remove();
//        return result+"-"+result2;
//    }

//    @JwtIgnore
//    @GetMapping("/mybatisCache")
//    public void mybatisCache() {
//        log.info("会话一查询");
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        TbUserDao tbUserDao = sqlSession.getMapper(TbUserDao.class);
//        TbUser tbUser = tbUserDao.queryById("10001");
//        System.out.println(tbUser.toString());
//        sqlSession.commit();
//        log.info("创建会话二，会话二修改数据，此时会清除二级缓存");
//        SqlSession sqlSession2 = sqlSessionFactory.openSession();
//        TbUserDao tbUserDao2 = sqlSession2.getMapper(TbUserDao.class);
//        TbUser tbUser1 = new TbUser();
//        tbUser1.setId("10001");
//        tbUser1.setUserName("mybatis二级缓存");
//        tbUserDao2.update(tbUser1);
//
//        log.info("会话二中查询结果，查数据库，放入二级缓存");
//        TbUser tbUser2 = tbUserDao2.queryById("10001");
//        System.out.println(tbUser2.toString());
//        log.info("此处必须commit");
//        sqlSession2.commit();
//        log.info("会话一此时再查询，会从二级缓存中查询，不会走库");
//        TbUser user = tbUserDao.queryById("10001");
//        System.out.println(user.toString());
//
//    }

//    @JwtIgnore
//    @GetMapping("/testCount")
//    public List<Integer> testCount() {
//        List<Integer> count = tbUserDao.getCount();
//        return count;
//    }
//
//    @JwtIgnore
//    @GetMapping("/testSingle")
//    public Integer testSingle(Integer num) {
//        this.count += num;
//        System.out.println(count);
//        return count;
//    }




//    public static void main(String[] args) {
//       System.out.println( new TbRoleServiceImpl().queryById("1"));
//    }
//        List<Integer> list = Arrays.asList(1,2,3,3,2,4,6,6);
//        System.out.println(list.stream().distinct().reduce(Integer::max).get());
//        List<String> mobile = new ArrayList<>();
//        mobile.add("18856034826");
//        mobile.add("18856031111");
//        List<String> newMoblies = new ArrayList<>();
//        newMoblies.add("18856032222");
//        newMoblies.add("18856034826");
//        newMoblies.add("188560311112");
//
//        newMoblies.forEach(e->{
//            if(mobile.contains(e)){
//                mobile.remove(e);
//            }
//        });
//        //System.out.println("mobile.size="+mobile.size());
//        setMobile();
//        String MAC_NAME = "HmacSHA1";
//        String ENCODING = "UTF-8";
//
//        try {
//            String s = HmacSHA1Encrypt("D9t4OgCT0n9K21Tr1UCd,GETapi-bj.clink.cn/list_cdr_ibs?AccessKeyId=26bb43f7c9d14da0c6e0e927f0a60475&Expires=3600&Timestamp=2021-11-16T15%3A55%3A30Z","D9t4OgCT0n9K21Tr1UCd");
//            System.out.println(s);
//            System.out.println(URLEncoder.encode(Base64Util.encode(s)));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }

    //二行制转字符串
    public static String byte2hex(byte[] b)
    {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; b!=null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1) {
                hs.append('0');
            }
            hs.append(stmp);
        }
        return hs.toString().toUpperCase();
    }


}