package com.kaishun.study.controller;

import com.kaishun.study.server.Server;
import com.kaishun.study.validator.JwtIgnore;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName:    HtmlController
 * Package:    com.kaishun.study.controller
 * Description:
 * Datetime:    2020/2/14   13:40
 * Author:   zhoukaishun
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Controller
@RequestMapping("/html")
public class HtmlController {

    @JwtIgnore
    @RequestMapping("/contest")
    public String getContest() {
        return "contest/contestIndex";
    }

    @JwtIgnore
    @RequestMapping("/user")
    public String getUser() {
        return "user/index";
    }

    @JwtIgnore
    @RequestMapping("/student")
    public String getUser1() {
        return "user/student";
    }

    @JwtIgnore
    @RequestMapping("/teacher")
    public String getUser2() {
        return "user/teacher";
    }

    @JwtIgnore
    @RequestMapping("/role")
    public String getRole() {
        return "role/roleIndex";
    }

    @JwtIgnore
    @RequestMapping("/menu")
    public String getMenu() {
        return "menu/menuIndex";
    }

    @JwtIgnore
    @RequestMapping("/server")
    public String server() {
        return "server/serverIndex";
    }

//    @JwtIgnore
//    @RequestMapping("/feedback")
//    public String feedback() {
//        return "feedback/feedbackIndex";
//    }

}
