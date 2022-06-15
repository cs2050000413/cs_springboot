package com.kaishun.study.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaishun.study.Result.RoleMenuResult;
import com.kaishun.study.entity.TbRole;
import com.kaishun.study.dao.TbRoleDao;
import com.kaishun.study.entity.TbUser;
import com.kaishun.study.exception.SystemException;
import com.kaishun.study.service.TbRoleService;
import com.kaishun.study.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * (TbRole)表服务实现类
 */
@Service("tbRoleService")
public class TbRoleServiceImpl implements TbRoleService {
    @Resource
    private TbRoleDao tbRoleDao;

    @Autowired
    private CommonUtils commonUtils;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TbRole queryById(String id) {
        return this.tbRoleDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TbRole> queryAllByLimit(int offset, int limit) {
        return this.tbRoleDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tbRole 实例对象
     * @return 实例对象
     */
    @Override
    public TbRole insert(TbRole tbRole, HttpServletRequest request) {
        //commonUtils.initTbData(tbRole,true);
        tbRole.setId(commonUtils.getUUID32());
        tbRole.setCreateTime(DateUtil.get14Date());
        this.tbRoleDao.insert(tbRole);
        return tbRole;
    }

    /**
     * 修改数据
     *
     * @param tbRole 实例对象
     * @return 实例对象
     */
    @Override
    public TbRole update(TbRole tbRole,  HttpServletRequest request) {
       // commonUtils.initTbData(tbRole,false);
        this.tbRoleDao.update(tbRole);
        return this.queryById(tbRole.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String id) {
        if("10001".equals(id)){
            throw new SystemException("不可删除管理员角色!");
        }
        return this.tbRoleDao.deleteById(id) > 0;
    }

    /**
     * 查询所有角色
     *
     * @return 角色规则列表
     */
    @Override
    public List<TbRole> getRoleList() {
        return tbRoleDao.findAll();
    }

    /**
     * 通过name和checkCode查询校验码是否正确
     * @return 是否成功
     */
    @Override
    public boolean checkCodeRight(String checkCode){
        if(tbRoleDao.checkCodeRight(checkCode).size()!=0)
            return true;
        else
            return false;
    }

    @Override
    public String getCodeId(String checkCode){
        return tbRoleDao.codeId(checkCode).getId();
    }

}