package com.sso.login.controller;

import com.sso.login.pojo.User;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.util.Optional;
import java.util.Set;

/**
 * This is Description
 *
 * @author YangBo
 * @date 2019/05/01
 */
@Controller
public class LoginController {

    private static Set<User> dbUsers;

    static {
        dbUsers.add(new User(0, "占三", "12345"));
        dbUsers.add(new User(1, "李三", "12345"));
        dbUsers.add(new User(2, "王三", "12345"));
        dbUsers.add(new User(3, "赵老爷子", "12345"));
    }

    public String doLogin(User user, HttpSession session) {

        String target = (String) session.getAttribute("target");

        Optional<User> first = dbUsers.stream().filter(dbUsers -> dbUsers.getUsername().equalsIgnoreCase(user.getUsername()) && dbUsers.getPassword().equals(user.getPassword())).findFirst();
        if (first.isPresent()) {
            //保存用户

        } else {
            //登录失败，返回登陆界面，并且在ession存msg
        }
        return "redirect" + target;
    }

}
