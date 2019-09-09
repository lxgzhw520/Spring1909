package com.lxgzhw.service.impl;

import com.lxgzhw.dao.IAccountDao;
import com.lxgzhw.dao.impl.AccountDaoImpl;
import com.lxgzhw.service.IAccountService;
import factory.BeanFactory;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {
    //private IAccountDao accountDao = new AccountDaoImpl();
    //通过工厂进行改造
    private IAccountDao accountDao =
            (IAccountDao) BeanFactory.getBean("accountDao");

    /**
     * 业务层模拟保存账户
     */
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
