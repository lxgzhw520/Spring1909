package com.lxgzhw.service;

import com.lxgzhw.domain.Account;

import java.util.List;

public interface IAccountService {
    List<Account> findAllAccount();

    Account findAccountById(Integer id);

    boolean saveAccount(Account account);

    boolean updateAccount(Account account);

    boolean deleteAccount(Integer id);

    /**
     * 转账业务
     *
     * @param sourceName 转出人名字
     * @param targetName 接收人名字
     * @param money      转出金额
     * @return 转账结果
     */
    boolean transfer(String sourceName, String targetName, Float money);
}
