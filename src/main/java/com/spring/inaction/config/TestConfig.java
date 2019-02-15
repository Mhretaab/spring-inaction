package com.spring.inaction.config;

import com.spring.inaction.config.thymeleaf.ThymeleafConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by mberhe on 2/15/19.
 */
@Configuration
@ComponentScan(basePackages = {"com.spring.inaction.service", "com.spring.inaction.dao", "com.spring.inaction.config.hibernate"})
@PropertySource("classpath:application.properties")
public class TestConfig {

}
