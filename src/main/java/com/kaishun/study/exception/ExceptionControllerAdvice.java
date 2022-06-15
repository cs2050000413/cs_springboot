package com.kaishun.study.exception;

import com.kaishun.study.enums.ResultEnum;
import com.kaishun.study.utils.ResultVO;
import com.kaishun.study.utils.ResultVOUtil;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * ClassName:    ExceptionControllerAdvice
 * Package:    com.kaishun.study.exception
 * Description:
 * Datetime:    2020/4/10   9:30
 * Author:   zhoukaishun
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler({BindException.class})
    public ResultVO handlerException(BindException e){
        // 从异常对象中拿到ObjectError对象

        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 然后提取错误提示信息进行返回
        return ResultVOUtil.error(ResultEnum.ParamsInvalid.getCode(),objectError.getDefaultMessage());
    }

    @ExceptionHandler({CodeMessageException.class})
    public ResultVO handlerException(CodeMessageException e){
       return  ResultVOUtil.error(e);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResultVO handlerException(MethodArgumentNotValidException e) {
        // 处理@Validated @Valid 拦截的参数异常
        String message = e.getBindingResult().getFieldErrors().stream().map(err -> {
            return err.getField() + err.getDefaultMessage();
        }).collect(Collectors.joining(";"));
        return ResultVOUtil.error(ResultEnum.ParamsInvalid.getCode(), message);
    }

    @ExceptionHandler(Exception.class)
    public ResultVO handlerException(Exception exception){
        Throwable throwable=exception;
        while (throwable.getCause()!=null){
            throwable=throwable.getCause();
        }
        if(throwable instanceof ConstraintViolationException) {
            return handlerException((ConstraintViolationException) throwable);
        }
        exception.printStackTrace();
        return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResultVO handlerException(ConstraintViolationException exception) {
        Set<ConstraintViolation<?>> set=exception.getConstraintViolations();
        for(ConstraintViolation constraintViolation:set){
            return ResultVOUtil.error(ResultEnum.SERVER_ERROR.getCode(),constraintViolation.getMessage());
        }
        return ResultVOUtil.error(ResultEnum.SERVER_ERROR);
    }


}
