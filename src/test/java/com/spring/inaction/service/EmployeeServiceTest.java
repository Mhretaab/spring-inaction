package com.spring.inaction.service;

import com.spring.inaction.config.AppConfig;
import com.spring.inaction.config.TestConfig;
import com.spring.inaction.model.Employee;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Created by mberhe on 2/14/19.
 */
//to configure a unit test that required Spring's dependency injection.
//@ActiveProfiles("testProfile")
@RunWith(SpringJUnit4ClassRunner.class)//  the class should use Spring's JUnit facilities.
@ContextConfiguration(classes = {TestConfig.class})// Indicates which XML files contain the ApplicationContext.
@DirtiesContext //indicate that the application context cached should be removed and reloaded after each test run.
@Transactional
//@Commit//equivalent to setting the default rollback mode to false
public class EmployeeServiceTest {
    /*@TransactionConfiguration
    @BeforeTransaction
    @AfterTransaction
    @Rollback --default*/

    @Autowired
    EmployeeService employeeService;

    @Autowired
    private SessionFactory sessionFactory;

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void saveEmployee() throws Exception {
        Employee employee1 = new Employee("Eden", "Samuel", "eden@email.com", 40000.036, "ssn00000001");
        employee1.setJoiningDate(new Date());
        employeeService.saveEmployee(employee1);

        Integer id = employee1.getId();

        sessionFactory.getCurrentSession().flush();
        assertNotNull(id);
    }

    @Test
    public void findAllEmployees() throws Exception {
        List<Employee> employeeList = employeeService.findAllEmployees();
        assertNotNull(employeeList);
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