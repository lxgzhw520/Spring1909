package ui;

import com.lxgzhw.service.impl.AccountServiceImpl;
import factory.BeanFactory;

/**
 * 模拟一个表现层,用于调用业务层
 */
public class Client {
    public static void main(String[] args) {
        //AccountServiceImpl accountService = new AccountServiceImpl();
        //1.通过工厂进行改造
        AccountServiceImpl accountService = (AccountServiceImpl) BeanFactory.getBean("accountService");
        accountService.saveAccount();
    }
}
