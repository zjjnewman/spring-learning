package com.atguigu.tx;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.AnnotationTransactionAttributeSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.sql.SQLException;

@EnableTransactionManagement
@ComponentScan("com.atguigu.tx")
@Configuration
public class TxConfig {

    @Bean
    public DruidDataSource dataSource() throws SQLException {

        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        druidDataSource.setUrl("jdbc:mysql://remotehost1:3306/test");
        druidDataSource.setUsername("jin");
        druidDataSource.setPassword("123");
        return druidDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() throws SQLException {
        // spring 对config有特殊处理，给容器加组件的，多次调用时从容器中找组件，而不是重新创建
        DruidDataSource druidDataSource = dataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(druidDataSource);
        return jdbcTemplate;
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws SQLException {
        return new DataSourceTransactionManager(dataSource());
    }

}
