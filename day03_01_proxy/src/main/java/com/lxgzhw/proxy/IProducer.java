package com.lxgzhw.proxy;

public interface IProducer {
    /**
     * 销售
     *
     * @param money 价格
     */
    void saleProduct(Float money);

    /**
     * 售后服务
     *
     * @param money 价格
     */
    void afterService(Float money);
}
