package com.sso.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This is Description
 *
 * @author YangBo
 * @date 2019/05/01
 */
@Controller
@RequestMapping("/view")
public class ViewController {
    @GetMapping("index")
    public String index() {
        return "index";
    }

}
