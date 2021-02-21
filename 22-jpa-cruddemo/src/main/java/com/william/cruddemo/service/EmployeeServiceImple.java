package com.william.cruddemo.service;

import com.william.cruddemo.dao.EmployeeDao;
import com.william.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImple implements EmployeeService {

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImple(@Qualifier("employeeDAOJpaImpl") EmployeeDao theEmployeeDAO){
        employeeDao = theEmployeeDAO;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    @Transactional
    public Employee findById(int theId) {
        return employeeDao.findById(theId);
    }

    @Override
    @Transactional
    public void save(Employee theEmployee) {
        employeeDao.saveEmployee(theEmployee);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        employeeDao.deleteById(theId);
    }
}
