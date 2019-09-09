package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration//表示是一个配置类
@ComponentScan("com.lxgzhw")//表示要扫描的包
@Import(JdbcConfig.class)//表示导入配置子类
@PropertySource("classpath:jdbcConfig.properties")//表示配置文件位置,传给@Value
public class SpringConfig {
}
