package com.lxgzhw.ui;

import com.lxgzhw.dao.IAccountDao;
import com.lxgzhw.service.IAccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo03 {
    public static void main(String[] args) {
        //1.获取核心容器
        ClassPathXmlApplicationContext app =
                new ClassPathXmlApplicationContext("beans.xml");

        //2.根据id获取bean对象
        IAccountService dao =
                (IAccountService) app.getBean("accountService");

        //3.使用对象
        dao.saveAccount();
    }
}
