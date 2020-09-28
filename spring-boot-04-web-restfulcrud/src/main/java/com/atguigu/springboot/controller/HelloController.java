package com.atguigu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {

//    @RequestMapping({"/","/index.html"})
//    public String index(){
//        return "index";
//    }

    @ResponseBody
    @RequestMapping("/hello")
    public Object hello(){
//        Map<String,Object> map = new HashMap<String,Object>();
//        map.put("1",2);
//        map.put("2",22);
//        map.put("3",222);
//        return map;
          return "Hello World";
    }

    //----不加 @ResponseBody 注解，则会把返回值 “success”封装成 ModelAndView
    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>你好</h1>");
        map.put("users", Arrays.asList("张三","李四","王五"));

        //----classpath:/templates.success.html   根据success请求，返回success.html展示
        return "success";
    }
}
