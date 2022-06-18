package com.kaishun.study.service;

import com.kaishun.study.entity.TbUser;
import com.kaishun.study.info.ForgetInfo;
import com.kaishun.study.utils.PageRequest;
import com.kaishun.study.utils.PageResult;
import com.kaishun.study.utils.ResultVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * (TbUser)表服务接口
 *
 * @author makejava
 * @since 2020-02-14 12:54:29
 */
public interface TbUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TbUser queryById(String id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TbUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tbUser 实例对象
     * @return 实例对象
     */
    TbUser insert(TbUser tbUser);

    /**
     * 修改数据
     *
     * @param tbUser 实例对象
     * @return 实例对象
     */
    TbUser update(TbUser tbUser,HttpServletRequest request);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(String id);

//    List<TbUser> findAll();

    String login(HttpServletResponse response, TbUser tbUser);

//    /**
//     * @description 根据手机号修改密码
//     * @author zhoukaishun
//     * @date 2020/3/15 10:29
//     */
//    void updatePasswordByPhone(String forgetPhone, String newPassword);
//
//    TbUser findTbUserByPhone(String forgetPhone);

    String getUserNameByToken(String token);

    List<TbUser> getUserByName(String name);

//    ResultVO forgetPassword(ForgetInfo info);

    void register(TbUser user, String checkCode);


    TbUser getUserInfo(HttpServletRequest request);

    int findContestUserByUserId(String userId);

    int addContestUser(String contestId,String userId);

    int deleteContestUser(String userId);

    List<TbUser> getUserList();

    List<TbUser> getStudentList();

    List<TbUser> getTeacherList();

    List<TbUser> getUserByContestId(String contestId);

    TbUser queryByUserName(String userName);

    void addUser(TbUser user,String roleId);
}