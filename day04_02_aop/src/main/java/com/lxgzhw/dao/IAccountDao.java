package com.lxgzhw.dao;

import com.lxgzhw.domain.Account;

public interface IAccountDao {
    Account findAccountByName(String name);
    void updateAccount(Account account);
}
