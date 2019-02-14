package com.spring.inaction.service;

import com.spring.inaction.model.Employee;

import java.util.List;

/**
 * Created by mberhe on 2/13/19.
 */
public interface EmployeeService {
    void saveEmployee(Employee employee);

    List<Employee> findAllEmployees();
    void deleteEmployeeBySsn(String ssn);
    Employee findBySsn(String ssn);
    void updateEmployee(Employee employee);
}
