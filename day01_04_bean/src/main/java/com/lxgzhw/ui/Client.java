package com.lxgzhw.ui;

import com.lxgzhw.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟一个表现层,用于调用业务层
 */
public class Client {
    public static void main(String[] args) {
        //1.获取spring的Ioc核心容器
        ApplicationContext app =
                new ClassPathXmlApplicationContext("beans.xml");

        //2.根据id获取对象
        IAccountService accountService =
                (IAccountService) app.getBean("accountService");

        //3.调用对象的方法
        accountService.saveAccount();
    }
}
