package com.lxgzhw.dao;

import com.lxgzhw.domain.Account;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IAccountDao {
    //这个注解用于执行sql语句
    @Select("select id,name,money from account")
    List<Account> findAll();
}
