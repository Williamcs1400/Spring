package com.william.cruddemo.dao;

import com.william.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    public List<Employee> findAll();

    public Employee findById(int theId);

    public void  saveEmployee(Employee theEmployee);

    public void deleteById(int theId);

}
