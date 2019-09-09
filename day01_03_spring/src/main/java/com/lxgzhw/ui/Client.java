package com.lxgzhw.ui;

import com.lxgzhw.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟一个表现层,用于调用业务层
 */
public class Client {
    public static void main(String[] args) {
        //通过spring的bean.xml配置来获取对象
        /**
         * ApplicationContext的三个常用实现类
         *  1.ClassPathXMLApplicationContext
         *      可以加载类路径下的配置文件
         *  2.FileSystemXmlApplicationContext
         *      可以加载有访问权限的系统任意位置的文件
         *  3.AnnotationConfigApplicationContext
         *      用于读取注解
         *
         * 核心容器两个接口引发的问题:
         *  1.ApplicationContext是读取配置,马上创建对象
         */
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
