package com.kaishun.study.exception;

import com.kaishun.study.enums.ResultEnum;
import lombok.Getter;

/**
 * ClassName:    CodeMessageException
 * Package:    com.test.demo.utils.exception
 * Description:
 * Datetime:    2020/1/17   13:00
 * Author:   zhoukaishun
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Getter
public class CodeMessageException extends RuntimeException {

    private static final long serialVersionUID = -4487259977719868255L;
    protected Integer code;


    public CodeMessageException(ResultEnum resultEnum) {

        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public CodeMessageException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public CodeMessageException(String message) {
        super(message);
        this.code = ResultEnum.SERVER_ERROR.getCode();
    }

    public Integer getCode() {
        return this.code;
    }


}
