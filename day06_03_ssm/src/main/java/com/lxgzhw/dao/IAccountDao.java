package com.lxgzhw.dao;

import com.lxgzhw.domain.Account;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IAccountDao {
    /**
     * 查询所有的用户
     *
     * @return 用户集合
     */
    @Select("select id,name,money from account")
    List<Account> findAll();

    /**
     * 增加一个用户
     *
     * @param account 用户对象
     */
    @Insert("insert into account (name,money) values(#{name},#{money})")
    void saveAccount(Account account);

    /**
     * 更新用户信息
     *
     * @param account 用户实体类对象
     * @return 更新结果
     */
    @Update("update account set name=#{name},money=#{money} where id=#{id}")
    boolean updateAccount(Account account);

    /**
     * 根据id删除用户
     *
     * @param id 用户id
     * @return 删除结果
     */
    @Delete("delete from account where id=#{id}")
    void deleteAccount(Integer id);

    /**
     * 根据id查询账户
     *
     * @param id 账户id
     * @return 账户实体类对象
     */
    @Select("select *from account where id=#{id}")
    Account findAccountById(Integer id);

    /**
     * 根据名字查询用户
     *
     * @param name 用户名字
     * @return 用户集合
     */
    @Select("select * from account where name like #{name}")
    List<Account> findAccountByName(String name);

    /**
     * 查询用户总数
     *
     * @return 用户总数
     */
    @Select("select count(id) from account")
    int findTotalAccount();
}
