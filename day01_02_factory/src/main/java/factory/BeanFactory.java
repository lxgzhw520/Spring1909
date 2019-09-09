package factory;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 一个创建Bean对象的工厂
 *
 * Bean:在计算机英语中,有可重用组件的含义
 * 它是创建我们Service对象的
 * 1.需要配置文件配置service和dao
 * 2.通过读取配置文件中的配置的内容,反射创建对象
 * 3.配置文件可以使xml也可以是properties
 */
public class BeanFactory {
    //1.定义一个Properties对象
    private static Properties properties;
    //1.1 定义一个容器,用于存放我们的对象
    private static Map<String,Object> beans;

    //2.使用静态代码块为Properties对象赋值
    static {
        properties=new Properties();
        try {
            properties.load(BeanFactory.class.getClassLoader()
            .getResourceAsStream("bean.properties"));
            //2.1实例化容器
            beans=new HashMap<String, Object>();
            //2.2取出配置文件中所有的keys
            Enumeration<Object> keys = properties.keys();
            //2.3遍历枚举
            while (keys.hasMoreElements()){
                String key = keys.nextElement().toString();
                //2.4.根据key获取value
                String beanPath = properties.getProperty(key);
                //2.5反射创建对象
                try {
                    Object value = Class.forName(beanPath).newInstance();
                    //2.6.把key和value存入容器中
                    beans.put(key,value);
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //3.写一个方法,返回对象

    /**
     * 根据bean的名称,获取bean对象
     * @param beanName bean的名称
     * @return bean对象
     */
    public static Object getBean(String beanName){
        Object bean = null;
        String beanPath=properties.getProperty(beanName);
        try {
            bean=Class.forName(beanPath).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 单例模式创建bean对象
     * @param beanName 对象的名字
     * @return 单例对象
     */
    public static Object getSingleBean(String beanName){
        return beans.get(beanName);
    }
}
