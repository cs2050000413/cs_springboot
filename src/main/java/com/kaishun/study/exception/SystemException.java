package com.kaishun.study.exception;

import com.kaishun.study.enums.CodeEnum;
import com.kaishun.study.enums.ResultEnum;
import lombok.Getter;

/**
 * ClassName:    SystemException
 * Package:    com.kaishun.study.exception
 * Description:
 * Datetime:    2020/2/18   12:31
 * Author:   zhoukaishun
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
public class SystemException extends CodeMessageException{


    public SystemException(CodeEnum codeEnum) {
        super(codeEnum.getMessage());
        this.code = codeEnum.getCode();
    }

    /**
     * @description 自定义错误描述和错误码
     * @author zhoukaishun
     * @date 2020/2/18 12:35
     */
    public SystemException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * @description 自定义错误描述
     * @author zhoukaishun
     * @date 2020/2/18 12:35
     */
    public SystemException(String message) {
        super(message);
        this.code = ResultEnum.SERVER_ERROR.getCode();
    }


}
