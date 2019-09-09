package com.lxgzhw.dao.impl;

import com.lxgzhw.dao.IAccountService;

public class AccountServiceImpl implements IAccountService {

    public void test1() {
        System.out.println("没有参数没有返回值的方法....");
    }

    public void test2(int i) {
        System.out.println("有参数的方法,参数是:" + i);
    }

    public int test03() {
        System.out.println("没有参数有返回值的方法");
        return 0;
    }
}
