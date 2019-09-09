package com.lxgzhw.service.impl;

import com.lxgzhw.dao.IAccountDao;
import com.lxgzhw.domain.Account;
import com.lxgzhw.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao dao;

    @Override
    public List<Account> findAllAccount() {
        return dao.findAllAccount();
    }

    @Override
    public Account findAccountById(Integer id) {
        return dao.findAccountById(id);
    }

    @Override
    public boolean saveAccount(Account account) {
        return dao.saveAccount(account);
    }

    @Override
    public boolean updateAccount(Account account) {
        return dao.updateAccount(account);
    }

    @Override
    public boolean deleteAccountById(Integer id) {
        return dao.deleteAccountById(id);
    }

}
