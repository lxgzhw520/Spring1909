package com.lxgzhw.controller;

import com.lxgzhw.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试错误的控制器类
 */
@Controller
public class ErrorController {
    @RequestMapping("/error")
    public String testException() throws SysException {
        System.out.println("模拟异常...");
        try {
            int a = 111 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("捕获到的错误...");
        }
        return "success";
    }
}
