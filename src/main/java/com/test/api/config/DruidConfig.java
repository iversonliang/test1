package com.test.api.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @create: 2024-03-18 01:09
 */
@Configuration
@Slf4j
public class DruidConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        DruidDataSource ds = new DruidDataSource();

        log.info("activeCount: {}", ds.getActiveCount());
        return ds;

    }
}
