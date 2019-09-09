package com.lxgzhw.service.impl;

import com.lxgzhw.dao.IAccountDao;
import com.lxgzhw.domain.Account;
import com.lxgzhw.service.IAccountService;

public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        //1.获取转出客户
        Account source = accountDao.findAccountByName(sourceName);
        //2.获取转入客户
        Account target = accountDao.findAccountByName(targetName);
        //3.转出客户余额减少
        source.setMoney(source.getMoney() - money);
        //4.转入客户余额增加
        target.setMoney(target.getMoney() + money);
        //System.out.println(3/0);
        //5.更新两个客户
        accountDao.updateAccount(source);
        accountDao.updateAccount(target);
        //6.输出更新信息
        System.out.println("转账成功");
    }
}
