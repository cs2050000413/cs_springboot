package com.kaishun.study.utils;

import com.kaishun.study.enums.CodeEnum;
import com.kaishun.study.enums.ResultEnum;
import com.kaishun.study.exception.CodeMessageException;

/**
 * ClassName:    ResultVOUtil
 * Package:    com.kaishun.study.utils
 * Description:
 * Datetime:    2020/2/14   13:18
 * Author:   zhoukaishun
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
public class ResultVOUtil {

    public static ResultVO loginSuccess(Object object) {
        ResultVO resultVO = new ResultVO<>();
        resultVO.setCode(ResultEnum.SUCCESS.getCode());
        resultVO.setMessage("登录成功");
        resultVO.setUrl("index");
        resultVO.setData(object);
        return resultVO;
    }


    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO<>();
        resultVO.setCode(ResultEnum.SUCCESS.getCode());
        resultVO.setMessage("操作成功");
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO success() {
        return success("操作成功");
    }

    public static ResultVO success(String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(ResultEnum.SUCCESS.getCode());
        resultVO.setStatus("成功");
        resultVO.setMessage(msg);
        return resultVO;
    }

    public static ResultVO success(String msg,Object data) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(ResultEnum.SUCCESS.getCode());
        resultVO.setStatus("成功");
        resultVO.setMessage(msg);
        resultVO.setData(data);
        return resultVO;
    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setStatus("失败");
        resultVO.setMessage(msg);
        return resultVO;
    }

    public static ResultVO error(CodeMessageException exception) {
        return error(exception.getCode(),exception.getMessage());
    }

    public static ResultVO error(CodeEnum codeEnum) {
        return error(codeEnum.getCode(),codeEnum.getMessage());
    }

}
