package ui;

import factory.BeanFactory;

public class Client01 {
    public static void main(String[] args) {
        //单例模式
        for (int i = 0; i < 5; i++) {
            Object accountDao = BeanFactory.getSingleBean("accountDao");
            System.out.println(accountDao);
        }
    }
}
