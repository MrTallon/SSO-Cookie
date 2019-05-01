package com.sso.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转逻辑
 *
 * @author YangBo
 * @date 2019/05/01
 */
@Controller
@RequestMapping("/view")
public class ViewController {

    /**
     * 跳转到登录页面
     * @return
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("test")
    public String test() {
        return "test";
    }

}
