package com.lxgzhw.test;

import com.lxgzhw.dao.IAccountDao;
import com.lxgzhw.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AccountTest {
    public static void main(String[] args) throws IOException {
        //1.读取配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

        //2.创建SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        //3.使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();

        //4.使用SqlSession创建dao代理对象
        IAccountDao accountDao = session.getMapper(IAccountDao.class);

        //5.使用代理对象执行方法
        List<Account> allAccount = accountDao.findAll();
        for (Account account : allAccount) {
            System.out.println(account);
        }
        //6.释放资源
        session.close();
        is.close();
    }
}
