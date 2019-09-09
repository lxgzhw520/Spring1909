package com.lxgzhw.dao.impl;

import com.lxgzhw.dao.IAccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {
    public AccountDaoImpl() {
    }

    public void saveAccount() {
        System.out.println("AccountDaoImpl持久层保存了账户.");
    }
}
