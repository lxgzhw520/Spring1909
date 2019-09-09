package com.lxgzhw.service.impl;

import com.lxgzhw.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {
    public AccountServiceImpl() {
        System.out.println("对象创建了");
    }

    public void saveAccount() {
        System.out.println("Service执行了保存账户的方法...");
    }
}
