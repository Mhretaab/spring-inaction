package com.spring.inaction.config.database;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by mberhe on 2/13/19.
 */
@Profile("Production")
@Configuration
public class ProdDatabaseConfig implements DatabaseConfig {
    @Override
    @Bean
    public DataSource createDataSource() {
        System.out.println("Creating PROD config");
        return new DriverManagerDataSource();
    }
}
