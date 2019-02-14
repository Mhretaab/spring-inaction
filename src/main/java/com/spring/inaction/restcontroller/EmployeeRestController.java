package com.spring.inaction.restcontroller;

import com.spring.inaction.model.Employee;
import com.spring.inaction.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by mberhe on 2/14/19.
 */
@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {
    final private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping
    public List<Employee> getEmployees(){
        return this.employeeService.findAllEmployees();
    }
}
