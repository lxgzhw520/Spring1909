package com.lxgzhw.ui;

import com.lxgzhw.dao.IAccountDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo02 {
    public static void main(String[] args) {
        //1.获取核心容器
        ClassPathXmlApplicationContext app =
                new ClassPathXmlApplicationContext("beans.xml");

        //2.根据id获取bean对象
        IAccountDao dao = (IAccountDao) app.getBean("accountDao");

        //3.使用对象
        dao.saveAccount();
    }
}
