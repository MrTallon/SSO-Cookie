package com.sso.login.controller;

import com.sso.login.pojo.User;
import com.sso.login.utils.LoginCache;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

/**
 * This is Description
 *
 * @author YangBo
 * @date 2019/05/01
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    private static Set<User> dbUsers;

    static {
        dbUsers = new HashSet<>();
        dbUsers.add(new User(0, "张三", "12345"));
        dbUsers.add(new User(1, "李三", "12345"));
        dbUsers.add(new User(2, "王三", "12345"));
        dbUsers.add(new User(3, "赵老爷子", "12345"));
        dbUsers.add(new User(4, "tallon", "12345"));
    }

    @PostMapping
    public String doLogin(User user, HttpSession session, HttpServletResponse response) {

        String target = (String) session.getAttribute("target");

        Optional<User> first = dbUsers.stream().filter(dbUsers -> dbUsers.getUsername().equalsIgnoreCase(user.getUsername()) && dbUsers.getPassword().equals(user.getPassword())).findFirst();
        if (first.isPresent()) {
            //保存用户登录信息
            String token = UUID.randomUUID().toString();
            LoginCache.loginUser.put(token, first.get());
            Cookie cookie = new Cookie("TOKEN",token);
            //二级域名必须相同
            cookie.setDomain("codeshop.com");
            response.addCookie(cookie);
            LoginCache.loginUser.put(token, first.get());
        } else {
            //登录失败，返回登陆界面，并且在ession存msg
            session.setAttribute("msg","用户名或密码错误");
            //session失效时间20s
            session.setMaxInactiveInterval(20);
            return "login";
        }

        return "redirect:" + target;
    }

    /**
     * 为其他子系统开放cookie信息
     * @return
     */
    @GetMapping("/info")
    @ResponseBody
    public ResponseEntity<User> getUserInfo(String token) {

        if (!StringUtils.isEmpty(token)) {
            User user = LoginCache.loginUser.get(token);
            return ResponseEntity.ok(user);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

    }
}
