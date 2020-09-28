package com.atguigu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping(value = "/user/login")
    //@RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            //给session赋值，只要登录成功了 session变量就有值，后续拦截器直接取 loginUser 是否有值即可
            session.setAttribute("loginUser",username);

            //登录成功  为了防止表单重复提交，可以重定向到主页
            //return ""dashboard;
            return "redirect:/main.html";
        }else{
            //登录失败
            map.put("msg","用户名密码错误");
            return "login";
        }
    }
}
