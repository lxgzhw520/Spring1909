package com.lxgzhw.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        //1.要求被代理类的对象用final修饰
        final Producer producer = new Producer();

        //2.创建代理对象
        IProducer proxyProducer = (IProducer) Proxy.newProxyInstance(
                //参数1:被代理对象的类加载器
                producer.getClass().getClassLoader(),
                //参数2:被代理对象的接口
                producer.getClass().getInterfaces(),
                //参数3:代理方法
                new InvocationHandler() {
                    /**
                     * 执行被代理对象的任何接口方法都会经过该方法
                     * @param proxy 代理对象
                     * @param method 当前执行的方法
                     * @param args 当前执行方法的参数
                     * @return 当前执行方法的返回值
                     * @throws Throwable 异常
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //提供增强的代码
                        //1.定义返回值
                        Object value = null;

                        //2.获取方法执行的参数
                        Float money = (Float) args[0];

                        //2.判断当前方法的名字
                        //2.1.如果是销售方法,则分钱
                        if ("saleProduct".equals(method.getName())) {
                            //2.2 生产厂家和经销商没人得一半的钱
                            value = method.invoke(producer, money * 0.5f);
                        }

                        return value;
                    }
                }
        );

        //3.代理对象执行销售方法
        proxyProducer.saleProduct(5000f);
    }
}
