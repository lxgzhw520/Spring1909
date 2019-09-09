package cm.lxgzhw.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/*
程序的耦合:
    耦合:程序间的依赖关系
        包括:
            类之间的依赖
            方法间的依赖

    解耦:降低程序间的依赖的关系
    实际开发中:
        应该做到:编译期不依赖,运行时才依赖
    解耦的思路:
        1.使用反射来创建对象,而避免使用new关键字
        2.通过读取配置文件来获取要创建的对象全限定类名
 */
public class Demo01 {
    public static void main(String[] args) throws Exception {
        //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java",
                "root",
                "root"
        );
        //3.获取操作数据库的预处理对象
        CallableStatement statement = connection.prepareCall("select *from account");
        //4.执行sql语句,获取结果集
        ResultSet resultSet = statement.executeQuery();
        //5.遍历结果集
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id") + ":" +
                    resultSet.getString("name"));
        }
        //6.释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
