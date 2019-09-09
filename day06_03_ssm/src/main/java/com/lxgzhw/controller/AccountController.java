package com.lxgzhw.controller;

import com.lxgzhw.domain.Account;
import com.lxgzhw.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        System.out.println("表现层:查询所有用户....");
        List<Account> allAccount = accountService.findAll();
        model.addAttribute("allAccount", allAccount);
        return "list";
    }

    @RequestMapping("/save")
    public String save(Account account, HttpServletRequest request) {
        System.out.println("表现层:保存账户");
        accountService.saveAccount(new Account(null, "root", 1000f));
        return "list";
    }


    @RequestMapping("/update")
    public String update() {
        System.out.println("表现层:保存账户");
        boolean flag = accountService.updateAccount(new Account(6, "root修改了", 2000f));
        System.out.println(flag ? "修改成功" : "修改失败...");
        return "list";
    }
}
