package com.spring.inaction.dao;

import com.spring.inaction.model.Employee;

import java.util.List;

/**
 * Created by mberhe on 2/13/19.
 */
public interface EmployeeDao {
    void saveEmployee(Employee employee);
    List<Employee> findAllEmployees();
    void deleteEmployeeBySsn(String Ssn);
    Employee findEmployeeBySsn(String Ssn);
    void updateEmployee(Employee employee);
}
