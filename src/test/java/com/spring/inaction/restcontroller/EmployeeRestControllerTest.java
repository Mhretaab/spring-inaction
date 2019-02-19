package com.spring.inaction.restcontroller;

import com.spring.inaction.config.AppConfig;
import com.spring.inaction.model.Employee;
import com.spring.inaction.service.EmployeeService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by mberhe on 2/15/19.
 */
/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@WebAppConfiguration*/
@RunWith(MockitoJUnitRunner.class)
public class EmployeeRestControllerTest {
    /*@Autowired
    WebApplicationContext wac;*/

    @Mock
    EmployeeService employeeService;

    MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        /*mockMvc = MockMvcBuilders
                .webAppContextSetup(wac)
                .build();*/
        mockMvc = MockMvcBuilders
                .standaloneSetup(new EmployeeRestController(employeeService))
                .build();
    }


    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getEmployees() throws Exception {
        List<Employee> employees = new ArrayList<Employee>() {{
            add(new Employee("Berhe", "Ayenew", "berhe@email.com", 10000.0, "100000000000ssn01"));
            add(new Employee("Ayenew", "Belay", "ayenew@email.com", 10000.0, "100000000000ssn02"));
            add(new Employee("Belay", "Tewelde", "belay@email.com", 10000.0, "100000000000ssn03"));
        }};

        Mockito.when(employeeService.findAllEmployees()).thenReturn(employees);

        mockMvc
                .perform(MockMvcRequestBuilders.get("/api/employees")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                /*.andExpect(MockMvcResultMatchers.jsonPath("firstName", new ))*/
                .andDo(MockMvcResultHandlers.print());
    }

}