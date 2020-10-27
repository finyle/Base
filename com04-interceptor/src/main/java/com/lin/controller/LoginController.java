package com.lin.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

public class LoginController {
    //登陆提交
    @PostMapping("/login")
    public String login(HttpSession session, String username, String pwd) {
        // 向session记录用户身份信息
        System.out.println("接收前端===" + username);
        if (username.equals("user1") && pwd.equals("123456")) {
            session.setAttribute("username", username);
            session.setAttribute("password", pwd);
            return "main";
        } else {
            session.setAttribute("username", null);
            session.setAttribute("password", null);
            return "login";
        }

    }

    //跳转到登陆页面
    @RequestMapping("/jumpLogin")
    public String jumpLogin() {
        return "login";
    }

    //跳转到成功页面
    @RequestMapping("/main")
    public String main() {
        return "main";
    }

    //退出登陆
    @RequestMapping("logout")
    public String logout(HttpSession session) {
        // session 过期
        session.invalidate();
        return "login";
    }
}
