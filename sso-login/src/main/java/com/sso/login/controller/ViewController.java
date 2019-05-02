package com.sso.login.controller;

import com.sso.login.pojo.User;
import com.sso.login.utils.LoginCache;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.Cookie;
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
    public String login(@RequestParam(required = false, defaultValue = "") String target, HttpSession session,
                        @CookieValue(required = false,value = "TOKEN") Cookie cookie) {

        if (StringUtils.isEmpty(target)) {
            target = "http://www.codeshop.com:9010";
        }
        // 如果已登录用户再次访问，直接返回请求页面
        if (cookie != null) {
            String value = cookie.getValue();
            User user = LoginCache.loginUser.get(value);
            if (user != null) {
                return "redirect:" + target;
            }
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
