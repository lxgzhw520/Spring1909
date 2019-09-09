package com.lxgzhw.dao.impl;

import com.lxgzhw.dao.IAccountDao;
import com.lxgzhw.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {

    @Override
    public Account findAccountById(Integer id) {
        List<Account> data = super.getJdbcTemplate().query(
                "select *from account where id=?",
                new BeanPropertyRowMapper<Account>(Account.class),
                id
        );
        return data.isEmpty() ? null : data.get(0);
    }

    @Override
    public Account findAccountByName(String name) {
        List<Account> data = super.getJdbcTemplate().query(
                "select *from account where name=?",
                new BeanPropertyRowMapper<Account>(Account.class),
                name
        );
        if (data.isEmpty()) {
            return null;
        }
        if (data.size() > 1) {
            throw new RuntimeException("结果集不唯一");
        }
        return data.get(0);
    }

    @Override
    public boolean updateAccount(Account account) {
        int num = super.getJdbcTemplate().update(
                "update account set name=?,money=? where id=?",
                account.getName(),
                account.getMoney(),
                account.getId()
        );
        return num > 0;
    }
}
