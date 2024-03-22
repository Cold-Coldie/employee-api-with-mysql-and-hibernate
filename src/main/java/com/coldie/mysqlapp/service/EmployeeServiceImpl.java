package com.coldie.mysqlapp.service;

import com.coldie.mysqlapp.dao.EmployeeDAO;
import com.coldie.mysqlapp.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDAO employeeDAO;

    @Transactional
    @Override
    public List<Employee> findAllEmployees() {
        return employeeDAO.findAllEmployees();
    }

    @Transactional
    @Override
    public Employee findEmployeeById(int id) {
        return employeeDAO.findEmployeeById(id);
    }

    @Transactional
    @Override
    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    @Transactional
    @Override
    public void updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);
    }

    @Transactional
    @Override
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }
}
