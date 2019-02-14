package com.spring.inaction.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by mberhe on 2/13/19.
 */
@Entity
@Table(name = "employee")
public class Employee implements Serializable{
    @Id
    @SequenceGenerator(name="pk_sequence",sequenceName="entity_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")
    @JsonIgnore
    private int id;

    private String firstName;
    private String lastName;
    private String email;
    private Double salary;

    private Date joiningDate;

    private String ssn;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String email, Double salary, String ssn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.salary = salary;
        this.ssn = ssn;
    }

    @PrePersist
    public void setJoiningDateIfNull(){
        if(this.joiningDate == null){
            this.joiningDate = new Date();
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        return ssn != null ? ssn.equals(employee.ssn) : employee.ssn == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (ssn != null ? ssn.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", joiningDate=" + joiningDate +
                ", ssn='" + ssn + '\'' +
                '}';
    }
}

