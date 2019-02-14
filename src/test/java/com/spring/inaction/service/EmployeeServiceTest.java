package com.spring.inaction.service;

import com.spring.inaction.config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by mberhe on 2/14/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class EmployeeServiceTest {
    @Autowired
    EmployeeService employeeService;

    @Test
    public void saveEmployee() throws Exception {
    }

    @Test
    public void findAllEmployees() throws Exception {
    }

    @Test
    public void deleteEmployeeBySsn() throws Exception {
    }

    @Test
    public void findBySsn() throws Exception {
    }

    @Test
    public void updateEmployee() throws Exception {
    }

}