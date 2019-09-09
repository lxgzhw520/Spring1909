package com.lxgzhw.dao;

import com.lxgzhw.domain.Account;

import java.util.List;

public interface IAccountDao {
    /**
     * 查询所有的账户
     *
     * @return 封装好的账户集合
     */
    List<Account> findAllAccount();

    /**
     * 根据id查询指定的账户
     *
     * @param id 账户的id
     * @return 账户对象
     */
    Account findAccountById(Integer id);

    /**
     * 根据账户实体类对象保存账户
     *
     * @param account 账户实体类对象
     * @return 保存的结果
     */
    boolean saveAccount(Account account);

    /**
     * 根据账户实体类对象更新账户
     *
     * @param account 账户实体类对象
     * @return 保存的结果
     */
    boolean updateAccount(Account account);

    /**
     * 根据账户的id删除数据库中的账户
     *
     * @param id 账户的id
     * @return 删除的结果
     */
    boolean deleteAccount(Integer id);

    /**
     * 根据账户的名字从数据库中查找账户
     *
     * @param name 账户的名字
     * @return 账户实体类对象
     */
    Account findAccountByName(String name);
}
