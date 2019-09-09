package com.lxgzhw.dao;

import com.lxgzhw.domain.Account;

import java.util.List;

public interface IAccountDao {
    /**
     * 查询所有的账户
     *
     * @return 账户列表
     */
    List<Account> findAllAccount();

    /**
     * 根据id查询指定的账户
     *
     * @param id 用户的id
     * @return 用户对象
     */
    Account findAccountById(Integer id);

    /**
     * 保存账户信息
     *
     * @param account 账户对象
     * @return 保存结果的布尔值
     */
    boolean saveAccount(Account account);

    /**
     * 更新账户信息
     *
     * @param account 账户对象
     * @return 更新结果的布尔值
     */
    boolean updateAccount(Account account);

    /**
     * 根据id删除指定的账户
     *
     * @param id 账户id
     * @return 删除结果的布尔值
     */
    boolean deleteAccountById(Integer id);
}
