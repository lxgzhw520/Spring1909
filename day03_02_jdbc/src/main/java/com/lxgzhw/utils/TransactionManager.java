package com.lxgzhw.utils;

import java.sql.SQLException;

/**
 * 和事务相关的工具类,包含:
 * 1.开启事务
 * 2.提交事务
 * 3.回滚事务
 * 4.释放连接
 */
public class TransactionManager {
    private ConnectionUtils connectionUtils;

    //开放一个set接口,是的可以通Spring的ioc动态配置连接工具类
    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    /**
     * 开启事务
     */
    public void beginTransaction() {
        try {
            connectionUtils.getThreadConnection()
                    .setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    public void commit() {
        try {
            connectionUtils.getThreadConnection()
                    .commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    public void rollback() {
        try {
            connectionUtils.getThreadConnection()
                    .rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放连接
     */
    public void release() {
        try {
            connectionUtils.getThreadConnection().close();
            connectionUtils.removeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
