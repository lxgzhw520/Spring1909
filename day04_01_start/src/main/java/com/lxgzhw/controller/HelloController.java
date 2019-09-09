package com.lxgzhw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    @RequestMapping(path = "/hello")
    public String sayHello() {
        System.out.println("hello springMVC!");
        //默认跳转到 pages/success.jsp
        return "success";
    }
}
