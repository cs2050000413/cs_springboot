package com.kaishun.study.controller;

import com.kaishun.study.validator.JwtIgnore;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName:    IndexController
 * Package:    com.kaishun.study.controller
 * Description:
 * Datetime:    2020/2/14   11:59
 * Author:   zhoukaishun
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Controller
public class IndexController {
    @JwtIgnore
    @RequestMapping("/")
    public String login(){
        return "login";
    }

    @JwtIgnore
    @RequestMapping("/index")
    public String index(){
        return "main";
    }

}
