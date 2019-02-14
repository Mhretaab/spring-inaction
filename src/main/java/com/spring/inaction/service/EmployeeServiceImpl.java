package com.spring.inaction.service;

import com.spring.inaction.dao.EmployeeDao;
import com.spring.inaction.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by mberhe on 2/13/19.
 */
@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    final private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public void saveEmployee(Employee employee) {
        this.employeeDao.saveEmployee(employee);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeDao.findAllEmployees();
    }

    @Override
    public void deleteEmployeeBySsn(String ssn) {
        employeeDao.deleteEmployeeBySsn(ssn);
    }

    @Override
    public Employee findBySsn(String ssn) {
        return employeeDao.findEmployeeBySsn(ssn);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeDao.updateEmployee(employee);
    }
}
