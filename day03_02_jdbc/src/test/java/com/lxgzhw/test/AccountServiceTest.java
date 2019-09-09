package com.lxgzhw.test;

import com.lxgzhw.domain.Account;
import com.lxgzhw.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {
    @Autowired
    @Qualifier("proxyAccountService")//指定配置的id
    private IAccountService as;

    //先看看有哪些人
    @Test
    public void testFindAll() {
        List<Account> allAccount = as.findAllAccount();
        System.out.println(allAccount);
    }

    @Test
    public void testTransfer() {
        boolean transfer = as.transfer("楚枫", "张大鹏", 100f);
        if (transfer) {
            System.out.println("转账成功.");
        }
    }
}
