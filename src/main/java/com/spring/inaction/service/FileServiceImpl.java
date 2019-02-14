package com.spring.inaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * Created by mberhe on 2/13/19.
 */
@Service("fileService")
public class FileServiceImpl implements FileService {
    @Value("${sourceLocation:/home/mberhe/IdeaProjects/tangio_postgres/spring-inaction/doc}")
    private String source;

    @Value("${destinationLocation:/home/mberhe/IdeaProjects/tangio_postgres/spring-inaction/doc}")
    private String destination;

    final private Environment environment;

    @Autowired
    public FileServiceImpl(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void readValues() {
        System.out.println("Driver classname: " + environment.getProperty("jdbc.driverClassName"));
        System.out.println("source location: " + source);
        System.out.println("destination location " + destination);
    }
}
