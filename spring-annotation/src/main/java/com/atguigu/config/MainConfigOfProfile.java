package com.atguigu.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;

/**
 * Profile 是spring提供的环境切换功能，比如 测试、生产、开发分支环境的
 */
@PropertySource("classpath:jdbc.properties")
@Configuration
public class MainConfigOfProfile implements EmbeddedValueResolverAware {

    @Autowired
    Environment environment;

    // 用次注解获取properties值
    @Value("${druid.username}")
    String username;

    // 用解析器获取properties值
    private StringValueResolver valueResolver;


    @Profile("product")
    @Bean
    public DataSource dataSourcePro(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(environment.getProperty("druid.url"));
        druidDataSource.setUsername(environment.getProperty("druid.username"));
        druidDataSource.setPassword(environment.getProperty("druid.password"));
        druidDataSource.setDriverClassName(environment.getProperty("druid.driverClassName"));
        System.out.println(environment.getProperty("druid.driverClassName"));
        return druidDataSource;
    }

    @Profile("test")
    @Bean
    // 用参数注解获取properties值
    public DataSource dataSourceTest(@Value("${druid.password}") String password){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(environment.getProperty("druid.url"));
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        String driverClassName = valueResolver.resolveStringValue("${druid.driverClassName}");
        druidDataSource.setDriverClassName(driverClassName);
        return druidDataSource;
    }

    @Profile("dev")
    @Bean
    public DataSource dataSourceDev(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(environment.getProperty("druid.url"));
        druidDataSource.setUsername(environment.getProperty("druid.username"));
        druidDataSource.setPassword(environment.getProperty("druid.password"));
        druidDataSource.setDriverClassName(environment.getProperty("druid.driverClassName"));
        return druidDataSource;
    }

    /**
     * Set the StringValueResolver to use for resolving embedded definition values.
     * 用解析器获取properties值
     * @param resolver
     */

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.valueResolver = resolver;
    }
}
