package com.lxgzhw.service.impl;

import com.lxgzhw.dao.IAccountDao;
import com.lxgzhw.domain.Account;
import com.lxgzhw.service.IAccountService;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao accountDao;

    @Autowired
    private SqlSessionFactoryBean sqlSessionFactory;

    @Override
    public List<Account> findAll() {
        System.out.println("业务层:查询所有账户...");
        return accountDao.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("业务层:保存账户.....");
        accountDao.saveAccount(account);
    }

    @Override
    public boolean updateAccount(Account account) {
        System.out.println("业务层:更新账户");
        boolean flag = accountDao.updateAccount(account);
        return flag;
    }

    @Override
    public void deleteAccount(Integer id) {
        System.out.println("业务层:删除账户");
        accountDao.deleteAccount(id);

    }

    @Override
    public Account findAccountById(Integer id) {
        Account account = accountDao.findAccountById(id);
        return account;
    }

    @Override
    public List<Account> findAccountByName(String name) {
        List<Account> account = accountDao.findAccountByName(name);
        return account;
    }

    @Override
    public int findTotalAccount() {
        int totalAccount = accountDao.findTotalAccount();
        return totalAccount;
    }
}
