package test;

import com.lxgzhw.domain.Account;
import com.lxgzhw.service.IAccountService;
import config.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 测试AccountService
 */
//声明测试的配置
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class AccountServiceTest {
    //自动注入,解决空指针异常
    @Autowired
    private IAccountService accountService;

    @Test
    public void testFindAll() {
        List<Account> allAccount = accountService.findAllAccount();
        for (Account account : allAccount) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {
        Account account = accountService.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave() {
        boolean zhang = accountService.saveAccount(new Account(
                null, "张大鹏", 3333.33F));
        System.out.println(zhang);
    }

    @Test
    public void testUpdate() {
        boolean flag = accountService.updateAccount(new Account(
                1, "楚枫", 12222f
        ));
        System.out.println(flag);
    }

    @Test
    public void testDelete() {
        boolean b = accountService.deleteAccountById(2);
        System.out.println(b);
    }
}
