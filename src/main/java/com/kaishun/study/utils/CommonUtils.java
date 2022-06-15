package com.kaishun.study.utils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaishun.study.config.JWTConfig;
import com.kaishun.study.entity.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.UUID;

/**
 * ClassName:    CommonUtils
 * Package:    com.kaishun.study.utils
 * Description:
 * Datetime:    2020/2/14   13:57
 * Author:   zhoukaishun
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Component
public class CommonUtils {



    /**
     * @description 获取32位uuid
     * @author zhoukaishun
     * @date 2020/2/14 13:58
     */
    public  String getUUID32() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }


    public void initTbData(Object obj,  boolean isCreate){
        try {
            Method setId = obj.getClass().getMethod("setId",String.class);
            Method setCreateTime = obj.getClass().getMethod("setCreateTime",String.class);
            Method setUpdateTime = obj.getClass().getMethod("setUpdateTime",String.class);
            Method setUpdateUser = obj.getClass().getMethod("setUpdateUser",String.class);
            try {
                if(isCreate){
                    setId.invoke(obj,getUUID32());
                    setCreateTime.invoke(obj,DateUtil.get14Date());
                }
                setUpdateTime.invoke(obj,DateUtil.get14Date());
                setUpdateUser.invoke(obj,JwtTokenUtil.getUsername(JWTConfig.base64Secret));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }


    public  void setTbUserInsertDefault(TbUser tbUser) {
        tbUser.setId(this.getUUID32());
//        //设置默认密码
//        tbUser.setUserPassword(StrToMd5.Md5("123456"));
        tbUser.setCreateTime(DateUtil.get14Date());
        tbUser.setUpdateTime(DateUtil.get14Date());
        tbUser.setUpdateUser("admin");
    }


    public PageInfo<?> getPageInfo(PageRequest pageRequest,List<?> list) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(list);
    }

}
