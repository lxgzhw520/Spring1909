package com.lxgzhw.jdbctemplate;

import com.lxgzhw.dao.impl.AccountDaoImpl;
import com.lxgzhw.domain.Account;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo02 {
    public static void main(String[] args) {
        //1.获取容器
        ClassPathXmlApplicationContext app =
                new ClassPathXmlApplicationContext("springmvc.xml");
        //2.获取对象
        AccountDaoImpl accountDao = (AccountDaoImpl) app.getBean("accountDao");

        //3.使用对象
        Account cuFeng = accountDao.findAccountById(1);
        System.out.println(cuFeng);
    }
}
