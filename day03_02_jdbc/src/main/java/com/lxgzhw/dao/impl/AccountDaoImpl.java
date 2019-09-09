package com.lxgzhw.dao.impl;

import com.lxgzhw.dao.IAccountDao;
import com.lxgzhw.domain.Account;
import com.lxgzhw.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class AccountDaoImpl implements IAccountDao {
    //执行sql语句的处理对象
    private QueryRunner runner;
    //连接数据库的工具类对象
    private ConnectionUtils connectionUtils;

    //开发一个set方法,让spring能够通过ioc动态配置
    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    //方便ioc动态配置连接工具
    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    @Override
    public List<Account> findAllAccount() {
        try {
            return runner.query(
                    connectionUtils.getThreadConnection(),
                    "select *from account",
                    new BeanListHandler<Account>(Account.class)
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findAccountById(Integer id) {
        try {
            return runner.query(
                    connectionUtils.getThreadConnection(),
                    "select *from account where id=?",
                    new BeanHandler<Account>(Account.class),
                    id
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean saveAccount(Account account) {
        try {
            int update = runner.update(
                    connectionUtils.getThreadConnection(),
                    "insert into account(name,money) values(?,?)",
                    account.getName(),
                    account.getMoney()
            );
            return update > 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateAccount(Account account) {
        try {
            int update = runner.update(
                    connectionUtils.getThreadConnection(),
                    "update account set name=?,money=? where id=?",
                    account.getName(),
                    account.getMoney(),
                    account.getId()
            );
            return update > 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteAccount(Integer id) {
        try {
            int update = runner.update(
                    connectionUtils.getThreadConnection(),
                    "delete from account where id=?",
                    id
            );
            return update > 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findAccountByName(String name) {
        Account account = null;
        try {
            List<Account> query = runner.query(
                    connectionUtils.getThreadConnection(),
                    "select *from account where name=?",
                    new BeanListHandler<Account>(Account.class),
                    name
            );
            if (query.size() == 1) {
                account = query.get(0);
            }
            if (query.size() > 1) {
                //需要写入日志
                System.out.println("数据有问题,查询出多个结果,可能遇到黑客.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return account;
    }
}
