package com.lxgzhw.service.impl;

import com.lxgzhw.dao.IAccountDao;
import com.lxgzhw.domain.Account;
import com.lxgzhw.service.IAccountService;

import java.util.List;

public class AccountServiceImpl implements IAccountService {
    private IAccountDao dao;

    //开放一个set方法,方便spring通过ioc配置
    public void setDao(IAccountDao dao) {
        this.dao = dao;
    }

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
    public boolean deleteAccount(Integer id) {
        return dao.deleteAccount(id);
    }

    /**
     * 转账
     * @param sourceName 转出人名字
     * @param targetName 接收人名字
     * @param money      转出金额
     * @return 转账结果
     */
    @Override
    public boolean transfer(String sourceName, String targetName, Float money) {
        try {
            //1.根据转出人名字查询转出账户
            Account source = dao.findAccountByName(sourceName);

            //2.根据接收人名字查询转入账户
            Account target = dao.findAccountByName(targetName);

            //3.转出账户余额减少
            source.setMoney(source.getMoney() - money);

            //4.转入账户余额增加
            target.setMoney(target.getMoney() + money);

            //5.更新转出账户
            dao.updateAccount(source);

            //6.更新转入账户
            dao.updateAccount(target);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
