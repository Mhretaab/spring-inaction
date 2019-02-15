package com.spring.inaction.controller;

import com.spring.inaction.config.AppConfig;
import com.spring.inaction.service.EmployeeService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by mberhe on 2/15/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@WebAppConfiguration
public class EmployeeControllerTest {
    @Autowired
    WebApplicationContext wac;

    @Mock
    EmployeeService employeeService;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        /*mockMvc = MockMvcBuilders
                .webAppContextSetup(wac)
                .build();*/
        mockMvc = MockMvcBuilders
                .standaloneSetup(new EmployeeController(employeeService))
                .build();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void index() throws Exception {
    }

}