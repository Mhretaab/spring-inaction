package com.spring.inaction.config;

import com.spring.inaction.config.thymeleaf.ThymeleafConfig;
import com.spring.inaction.pojo.HelloWorld;
import com.spring.inaction.pojo.HelloWorldImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

/**
 * Created by mberhe on 2/13/19.
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"com.spring.inaction"})
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Autowired
    public DataSource dataSource;

    @Bean(name = "helloWorldBean")
    @Description("This is a simple hello world bean")
    public HelloWorld helloWorld(){
        return new HelloWorldImpl();
    }

    /*
     * PropertySourcesPlaceHolderConfigurer Bean only required for @Value("{}") annotations.
     * Remove this bean if you are not using @Value annotations for injecting properties.
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
