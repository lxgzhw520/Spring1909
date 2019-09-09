package com.lxgzhw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 演示拦截器
 */
@Controller
public class InterceptorController {
    @RequestMapping("/interceptor")
    public String interceptor() {
        System.out.println("执行了控制器方法....");
        return "success";
    }
}
