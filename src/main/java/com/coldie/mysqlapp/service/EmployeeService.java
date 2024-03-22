package com.coldie.mysqlapp.service;

import com.coldie.mysqlapp.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAllEmployees();

    Employee findEmployeeById(int id);

    void saveEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployee(int id);
}
