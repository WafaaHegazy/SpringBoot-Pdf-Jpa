package me.aboullaite.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the employee database table.
 */
@Entity
@NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "employee_email")
    private String employeeEmail;

    @Column(name = "employee_first_name")
    private String employeeFirstName;

    @Column(name = "employee_last_name")
    private String employeeLastName;

    @Column(name = "employee_salary")
    private String employeeSalary;

    public Employee() {
    }

    public int getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(final int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeEmail() {
        return this.employeeEmail;
    }

    public void setEmployeeEmail(final String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeFirstName() {
        return this.employeeFirstName;
    }

    public void setEmployeeFirstName(final String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeLastName() {
        return this.employeeLastName;
    }

    public void setEmployeeLastName(final String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public String getEmployeeSalary() {
        return this.employeeSalary;
    }

    public void setEmployeeSalary(final String employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

}