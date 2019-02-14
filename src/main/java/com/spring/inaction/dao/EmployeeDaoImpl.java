package com.spring.inaction.dao;

import com.spring.inaction.model.Employee;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mberhe on 2/13/19.
 */
@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao implements EmployeeDao {
    @Override
    public void saveEmployee(Employee employee) {
        System.out.println("Employee " + employee.getFirstName() + " saved to DB");
        persist(employee);
    }

    @Override
    public List<Employee> findAllEmployees() {
        Criteria criteria = getSession().createCriteria(Employee.class);
        return (List<Employee>) criteria.list();
    }

    @Override
    public void deleteEmployeeBySsn(String Ssn) {
        Query query = getSession().createSQLQuery("DELETE FROM employee WHERE ssn = :ssn");
        query.setString("ssn", Ssn);
        query.executeUpdate();
    }

    @Override
    public Employee findEmployeeBySsn(String Ssn) {
        Criteria criteria = getSession().createCriteria(Employee.class);
        criteria.add(Restrictions.eq("ssn", Ssn));
        return (Employee) criteria.uniqueResult();
    }

    @Override
    public void updateEmployee(Employee employee) {
        getSession().update(employee);
    }
}
