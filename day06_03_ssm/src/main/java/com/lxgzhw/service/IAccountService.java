package com.lxgzhw.service;

import com.lxgzhw.domain.Account;

import java.util.List;

public interface IAccountService {
    List<Account> findAll();

    void saveAccount(Account account);

    boolean updateAccount(Account account);

    void deleteAccount(Integer id);

    Account findAccountById(Integer id);

    List<Account> findAccountByName(String name);

    int findTotalAccount();
}
