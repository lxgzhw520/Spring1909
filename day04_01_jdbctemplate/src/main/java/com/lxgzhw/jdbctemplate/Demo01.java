package com.lxgzhw.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Demo01 {
    public static void main(String[] args) {
        //准备数据源(spring的内置数据源)
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql:///java");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("root");

        //1.创建JDBCTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(driverManagerDataSource);
        
        //2.执行操作
        jdbcTemplate.execute(
                "insert into account(name,money) values('aaa',1000)");
    }
}
