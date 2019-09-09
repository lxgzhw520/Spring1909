package com.lxgzhw.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 连接数据库的工具类,用于从数据源获取一个连接,并实现和线程的绑定
 */
public class ConnectionUtils {
    private ThreadLocal<Connection> t1 =
            new ThreadLocal<Connection>();
    private DataSource dataSource;

    //数据源通过spring的ioc动态bean配置
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取当前线程上的连接
     *
     * @return Connection对象
     */
    public Connection getThreadConnection() {
        try {
            //1.先从ThreadLocal上获取
            Connection connection = t1.get();
            //2判断当前线程上是否有连接
            if (connection == null) {
                //2.1没有,从数据源获取一个连接,并存入ThreadLocal中
                connection = dataSource.getConnection();
                t1.set(connection);
            }
            //3.返回当前线程上的连接
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 把连接和线程解绑
     */
    public void removeConnection() {
        t1.remove();
    }
}
