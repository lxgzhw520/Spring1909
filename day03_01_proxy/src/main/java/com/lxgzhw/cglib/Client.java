package com.lxgzhw.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Client {
    public static void main(final String[] args) {
        //1.创建厂家对象
        final Producer producer = new Producer();

        //2.创建cglib的代理对象
        Producer cglibProducer = (Producer) Enhancer.create(
                //2.1 第一个参数是被代理对象的字节码
                producer.getClass(),
                //2.2 第二个参数是MethodInterceptor实现类
                new MethodInterceptor() {
                    /**
                     * 执行被代理对象的任何接口方法都会经过该方法
                     * @param o 被代理对象
                     * @param method 当前执行的方法
                     * @param objects 当前执行方法的参数
                     * @param methodProxy 执行方法的代理对象
                     * @return 当前执行方法的返回值
                     * @throws Throwable
                     */
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        //2.3 创建返回值
                        Object value = null;

                        //2.4 获取方法执行的参数
                        Float money = (Float) objects[0];

                        //2.5 判断方法名,根据方法名反射做不同的处理
                        //2.5.1 这里假设销售方法取.2的提成
                        if ("saleProduct".equals(method.getName())) {
                            value = method.invoke(producer, money * 0.8f);
                        }
                        return value;
                    }
                }
        );

        //3.调用动态代理对象的方法
        cglibProducer.saleProduct(29999f);
    }
}
