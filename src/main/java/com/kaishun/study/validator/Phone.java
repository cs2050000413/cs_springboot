package com.kaishun.study.validator;

import com.kaishun.study.enums.ResultEnum;
import org.springframework.util.StringUtils;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import javax.xml.transform.Result;
import java.lang.annotation.*;

/**
 * ClassName:    Phone
 * Package:    com.kaishun.study.validator
 * Description:
 * Datetime:    2020/4/8   13:34
 * Author:   zhoukaishun
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {Phone.PhoneValidator.class})
public @interface Phone {

    String message() default "手机格式不正确";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class PhoneValidator implements ConstraintValidator<Phone, String> {

        private String regex;

        @Override
        public void initialize(Phone constraint) {
            regex = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$";
        }
        @Override
        public boolean isValid(String obj, ConstraintValidatorContext context) {
            if(StringUtils.isEmpty(obj)) {
                return false;
            }
            if (obj.length() != 11) {
                return false;
            }
            if (obj.matches(regex)) {
                return true;
            }
            return false;
        }
    }


}
