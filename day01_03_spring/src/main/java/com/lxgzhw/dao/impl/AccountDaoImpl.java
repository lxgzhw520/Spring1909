package com.lxgzhw.dao.impl;

import com.lxgzhw.dao.IAccountDao;

/**
 * 账户的持久层实现类
 */
public class AccountDaoImpl implements IAccountDao {
    /**
     * 模拟保存用户
     */
    public void saveAccount() {
        System.out.println("AccountDaoImpl持久层保存了账户.");
    }
}
