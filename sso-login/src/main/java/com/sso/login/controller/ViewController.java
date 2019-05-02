package com.sso.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

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
     *
     * @return
     */
    @GetMapping("/login")
    public String login(@RequestParam(required = false, defaultValue = "") String target, HttpSession session) {

        if (StringUtils.isEmpty(target)) {
            target = "http://www.codeshop.com";
        }
        // 地址合法性校验
        session.setAttribute("target", target);
        return "login";
    }

    @GetMapping("test")
    public String test() {
        return "test";
    }

}
