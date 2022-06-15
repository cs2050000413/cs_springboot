package com.kaishun.study.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName:    JwtIgnore
 * Package:    com.kaishun.study.validator
 * Description:
 * Datetime:    2020/4/24   14:29
 * Author:   kaishun.zhou
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface JwtIgnore {
}
