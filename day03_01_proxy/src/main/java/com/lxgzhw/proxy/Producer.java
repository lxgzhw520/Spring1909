package com.lxgzhw.proxy;

public class Producer implements IProducer {

    @Override
    public void saleProduct(Float money) {
        System.out.println("销售产品,并拿到钱:" + money);
    }

    @Override
    public void afterService(Float money) {
        System.out.println("提供售后服务,并拿到钱:" + money);
    }
}
