package com.lxgzhw.jdbctemplate;

import com.lxgzhw.dao.impl.AccountDaoImpl;
import com.lxgzhw.domain.Account;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo03 {
    public static void main(String[] args) {
        //1.获取容器
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("springmvc.xml");
        //2.获取对象
        AccountDaoImpl accountDao = app.getBean("accountDao", AccountDaoImpl.class);
        //3.使用对象
        Account cuFeng = accountDao.findAccountByName("楚枫");
        System.out.println(cuFeng);
    }
}
