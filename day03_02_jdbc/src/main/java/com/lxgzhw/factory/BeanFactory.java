package com.lxgzhw.factory;

import com.lxgzhw.service.IAccountService;
import com.lxgzhw.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BeanFactory {
    private IAccountService accountService;
    private TransactionManager transactionManager;

    //用于spring通过ioc动态配置accountService对象
    public final void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    //用于spring通过ioc动态配置transactionManager对象
    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public IAccountService getAccountService() {
        return (IAccountService) Proxy.newProxyInstance(
                accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 增强方法
                     * @param proxy 当前的代理对象
                     * @param method 当前执行的方法
                     * @param args 当前执行方法的参数
                     * @return 当前方法的返回值
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //所有的测试方法都要经过这个方法
                        if ("test".equals(method.getName())) {
                            return method.invoke(accountService, args);
                        }
                        Object value = null;
                        try {
                            //1.开启事务
                            transactionManager.beginTransaction();
                            //2.执行操作
                            value = method.invoke(accountService, args);
                            //3.提交事务
                            transactionManager.commit();
                            //4.返回结果
                            return value;
                        } catch (Exception e) {
                            //5.回滚操作
                            transactionManager.rollback();
                            throw new RuntimeException(e);
                        } finally {
                            //6.释放连接
                            transactionManager.release();
                        }
                    }
                }
        );
    }
}
