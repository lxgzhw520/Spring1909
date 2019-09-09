package com.lxgzhw.dao.impl;

import com.lxgzhw.dao.IAccountDao;
import com.lxgzhw.domain.Account;
import com.lxgzhw.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class AccountDaoImpl implements IAccountDao {
    private QueryRunner runner;
    private ConnectionUtils connectionUtils;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    @Override
    public Account findAccountByName(String name) {
        try {
            List<Account> accounts = runner.query(connectionUtils.getThreadConnection(),
                    "select *from account where name=?",
                    new BeanListHandler<Account>(Account.class),
                    name);
            if (accounts.isEmpty()) {
                return null;
            }
            if (accounts.size() > 1) {
                throw new RuntimeException("结果集不唯一");
            }
            return accounts.get(0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            runner.update(connectionUtils.getThreadConnection(),
                    "update account set name=?,money=? where id=?",
                    account.getName(),
                    account.getMoney(),
                    account.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
