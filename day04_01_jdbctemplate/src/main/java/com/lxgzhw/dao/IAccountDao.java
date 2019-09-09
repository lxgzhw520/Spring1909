package com.lxgzhw.dao;

import com.lxgzhw.domain.Account;

public interface IAccountDao {
    /**
     * 根据id查询账户
     *
     * @param id 账户id
     * @return 账户实体类对象
     */
    Account findAccountById(Integer id);

    /**
     * 根据名字查询账户
     *
     * @param name 账户名字
     * @return 账户实体类对象
     */
    Account findAccountByName(String name);

    /**
     * 根据账户实体类对象修改数据库中的账户信息
     *
     * @param account 账号实体类对象
     * @return 更新结果
     */
    boolean updateAccount(Account account);
}
