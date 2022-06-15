package com.kaishun.study.utils;

import com.kaishun.study.enums.ResultEnum;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ClassName:    PhoneUtils
 * Package:    com.kaishun.study.utils
 * Description:
 * Datetime:    2020/3/14   10:41
 * Author:   zhoukaishun
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
public class MobileUtils {

        /**
         * @description 验证手机号是否合法
         * @author zhoukaishun
         * @date 2020/3/14 11:19
         */
        public static boolean isMobile(String mobile){
            if (mobile.length() != 11)
            {
                return false;
            }else{
                // "[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
                String regex = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$";
                Pattern p = Pattern.compile(regex);
                Matcher m = p.matcher(mobile);
                if(m.matches()){
                    return true;
                }
                return false;
            }
        }
        /**
         * @description 检验是否发送成功
         * @author zhoukaishun
         * @date 2020/3/14 11:21
         */
        public static ResultVO sendResult(String data){
            if(data.contains("\"Code\":\"OK\"")){
                return ResultVOUtil.success("发送成功");
            }else if(data.contains("\"Code\":\"isv.BUSINESS_LIMIT_CONTROL\"")){
                return ResultVOUtil.success("发送频率超限");
            }else{
                return ResultVOUtil.error(ResultEnum.UNKNOWN_ERROR);
            }
        }


}
