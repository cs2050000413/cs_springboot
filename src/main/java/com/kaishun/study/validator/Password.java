package com.kaishun.study.validator;

import com.kaishun.study.enums.ResultEnum;
import org.springframework.util.StringUtils;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName:    Password
 * Package:    com.kaishun.study.validator
 * Description:
 * Datetime:    2020/4/8   16:49
 * Author:   zhoukaishun
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = Password.PasswordValidator.class)
public @interface Password {

    String message() default "密码安全等级不够，需要数字和密码的组合";

    ResultEnum result() default ResultEnum.ParamsInvalid;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


    public class PasswordValidator implements ConstraintValidator<Password, String> {

        private String regex;

        @Override
        public void initialize(Password constraintAnnotation) {
            regex = "(\\d+.*[a-zA-Z]+|[a-zA-Z]+.*\\d+)";
        }

        @Override
        public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
            if(StringUtils.isEmpty(value)) {
                return false;
            }
            if (value.matches(regex)) {
                return true;
            }
            return false;
        }
    }
}
