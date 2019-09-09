package com.lxgzhw.dao.impl;

import com.lxgzhw.dao.IAccountDao;
import com.lxgzhw.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {
    //查询对象
    @Autowired
    private QueryRunner runner;


    @Override
    public List<Account> findAllAccount() {
        try {
            return runner.query(
                    "select *from account",
                    new BeanListHandler<Account>(Account.class)
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Account findAccountById(Integer id) {
        try {
            return runner.query(
                    "select * from account where id=?",
                    new BeanHandler<Account>(Account.class),
                    id
            );
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean saveAccount(Account account) {
        try {
            int update = runner.update(
                    "insert into account(name,money) values(?,?)",
                    account.getName(),
                    account.getMoney()
            );
            if (update > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateAccount(Account account) {
        try {
            int update = runner.update(
                    "update account set name=?,money=? where id=?",
                    account.getName(),
                    account.getMoney(),
                    account.getId());
            if (update > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteAccountById(Integer id) {
        try {
            int update = runner.update(
                    "delete from account where id=?",
                    id
            );
            if (update > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
