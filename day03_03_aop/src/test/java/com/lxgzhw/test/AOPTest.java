package com.lxgzhw.test;

import com.lxgzhw.dao.IAccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {
    public static void main(String[] args) {
        //1.获取容器
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("bean.xml");

        //2.获取对象
        IAccountService accountService = (IAccountService) app.getBean("accountService");

        //3.执行方法
        accountService.test1();
        accountService.test2(222);
        accountService.test03();
    }
}
