package com.kaishun.study.service.impl;

import com.kaishun.study.config.JWTConfig;
import com.kaishun.study.entity.TbUser;
import com.kaishun.study.dao.TbUserDao;
import com.kaishun.study.entity.TbUserRole;
import com.kaishun.study.enums.ResultEnum;
import com.kaishun.study.exception.SystemException;
import com.kaishun.study.info.ForgetInfo;
import com.kaishun.study.service.RedisService;
import com.kaishun.study.service.TbRoleService;
import com.kaishun.study.service.TbUserRoleService;
import com.kaishun.study.service.TbUserService;
import com.kaishun.study.utils.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * (TbUser)表服务实现类
 *
 * @author makejava
 * @since 2020-02-14 12:54:29
 */
@Service("tbUserService")
public class TbUserServiceImpl implements TbUserService {
    @Resource
    private TbUserDao tbUserDao;

    @Resource
    private RedisService redisService;

    @Resource
    private CommonUtils commonUtils;

    @Resource
    private TbUserService tbUserService;

    @Resource
    private TbRoleService tbRoleService;

    @Resource
    private TbUserRoleService tbUserRoleService;


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbUser queryById(String id) {
        return this.tbUserDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<TbUser> queryAllByLimit(int offset, int limit) {
        return this.tbUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tbUser 实例对象
     * @return 实例对象
     */
    @Override
    public TbUser insert(TbUser tbUser) {
        checkUserName(tbUser.getUserName());
        commonUtils.setTbUserInsertDefault(tbUser);
        this.tbUserDao.insert(tbUser);
        return tbUser;
    }

    public void checkUserName(String userName) {
        TbUser user = tbUserService.queryByUserName(userName);
        if (user != null) {
            throw new SystemException(ResultEnum.USERNAME_IS_USER);
        }
    }

    /**
     * 修改数据
     *
     * @param tbUser 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional
    public TbUser update(TbUser tbUser, HttpServletRequest request) {
        if ("10001".equals(tbUser.getId())) {
            throw new SystemException("不可修改管理员信息，以防止被随意更改密码。");
        }
//        checkUserName(tbUser.getUserName());
        commonUtils.initTbData(tbUser, false);
        this.tbUserDao.update(tbUser);
        return this.queryById(tbUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        //此处做不可删除管理员的限制
        if ("10001".equals(id)) {
            throw new SystemException("不可删除管理员");
        }
        return this.tbUserDao.deleteById(id) > 0;
    }

//
//    @Override
//    public List<TbUser> findAll() {
//        return tbUserDao.findAll();
//    }

    @Override
    public List<TbUser> getStudentList() {
        return tbUserDao.findStudent();
    }

    @Override
    public List<TbUser> getTeacherList() {
        return tbUserDao.findTeacher();
    }

    @Override
    public String login(HttpServletResponse response, TbUser tbUser) {
        //明文密码MD5加密
        tbUser.setUserPassword(StrToMd5.Md5(tbUser.getUserPassword()));
        TbUser user = tbUserDao.login(tbUser);

        if (user == null) {
            throw new SystemException(ResultEnum.LOGIN_ERROR);
        }
        // 创建token
        String token = JwtTokenUtil.createJWT(user.getId(), user.getUserName(), "user_role");
        // 将token放在响应头
        response.setHeader(JwtTokenUtil.AUTH_HEADER_KEY, JwtTokenUtil.TOKEN_PREFIX + token);
        redisService.set(token, user.getId());
        Integer count = Integer.parseInt(redisService.get("count") == null ? "0" : redisService.get("count"));
        redisService.set("count", count+1);
        return token;
    }

//    @Override
//    public void updatePasswordByPhone(String forgetPhone, String newPassword) {
//        String password = StrToMd5.Md5(newPassword);
//        tbUserDao.updatePasswordByPhone(forgetPhone, password);
//
//    }

//    @Override
//    public TbUser findTbUserByPhone(String forgetPhone) {
//        return tbUserDao.findTbUserByPhone(forgetPhone);
//    }

    @Override
    public String getUserNameByToken(String token) {
        //此处也可用JwtTokenUtil获取更加方便，但是此处因为JWT是我后面加的，这里就没做修改
        String userId = redisService.get(token);
        TbUser tbUser = tbUserDao.queryById(userId);
        return tbUser != null ? tbUser.getUserName() : null;

    }

    @Override
    public List<TbUser> getUserByName(String name) {
        return tbUserDao.getUserByName("%" + name + "%");
    }

//    @Override
//    public ResultVO forgetPassword(ForgetInfo info) {
//        if (smsUtils.verification(info.getForgetPhone(), info.getForgetVerificationCode())) {
//            TbUser tbUser = tbUserDao.findTbUserByPhone(info.getForgetPhone());
//            if (tbUser == null) {
//                return ResultVOUtil.error(ResultEnum.PHONE_NOT_BIND_USER);
//            }
//            info.setNewPassword(StrToMd5.Md5(info.getNewPassword()));
//            tbUserDao.updatePasswordByPhone(info.getForgetPhone(), info.getNewPassword());
//            return ResultVOUtil.success();
//        } else {
//            return ResultVOUtil.error(ResultEnum.PHONE_CODE_ERROR);
//        }
//    }

    @Override
    public void register(TbUser user, String checkCode) {
        TbUser tbUser = tbUserDao.findTbUserByPhone(user.getPhone());
        if (tbUser != null) {
            throw new SystemException(ResultEnum.PHONE_IS_USER);
        }
            String password = user.getUserPassword();
            commonUtils.setTbUserInsertDefault(user);
            user.setUserPassword(StrToMd5.Md5(password));
            this.insert(user);
            TbUserRole tbUserRole = new TbUserRole();
            tbUserRole.setUserId(user.getId());
            tbUserRole.setRoleId(tbRoleService.getCodeId(checkCode));//查询校验码对应角色
            tbUserRole.setId(commonUtils.getUUID32());
            tbUserRole.setCreateTime(DateUtil.get14Date());
            tbUserRole.setUpdateTime(DateUtil.get14Date());
            tbUserRole.setUpdateUser("admin");
            tbUserRoleService.insert(tbUserRole);
    }

    @Override
    public TbUser getUserInfo(HttpServletRequest request) {
        return this.queryById(JwtTokenUtil.getUserId(JWTConfig.base64Secret));
    }

    @Override
    public List<TbUser> getUserList() {
        return tbUserDao.findAll();
    }

    @Override
    public TbUser queryByUserName(String userName) {
        return tbUserDao.queryByUserName(userName);
    }

    @Override
    public void addUser(TbUser user,String roleId) {
        TbUser tbUser = tbUserDao.findTbUserByPhone(user.getPhone());
        if (tbUser != null) {
            throw new SystemException(ResultEnum.PHONE_IS_USER);
        }
        commonUtils.setTbUserInsertDefault(user);
        this.tbUserDao.insert(user);
        TbUserRole tbUserRole = new TbUserRole();
        tbUserRole.setUserId(user.getId());
        tbUserRole.setRoleId(roleId);
        tbUserRole.setId(commonUtils.getUUID32());
        tbUserRole.setCreateTime(DateUtil.get14Date());
        tbUserRole.setUpdateTime(DateUtil.get14Date());
        tbUserRole.setUpdateUser("admin");
        tbUserRoleService.insert(tbUserRole);
    }
}