package com.lxgzhw.controller;

import com.lxgzhw.domain.Account;
import com.lxgzhw.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller//表示是一个控制器
@RequestMapping("/param")//表示一级路径
public class ParamController {
    @RequestMapping("/test")//表示二级路径
    public String test(String username, String password) {
        //括号里面的参数必须和发送的参数依次对应
        //不对应取到的是null,不会报错
        System.out.println("用户名:" + username);
        System.out.println("密码:" + password);

        return "success";
    }

    @RequestMapping("/saveAccount")//表示二级路径
    public String saveAccount(Account account) {
        //提交的数据会自动封装为对象,无需手动封装
        System.out.println(account);
        return "success";
    }

    @RequestMapping("/date")
    public String date(User user) {
        System.out.println(user);
        return "success";
    }

}
