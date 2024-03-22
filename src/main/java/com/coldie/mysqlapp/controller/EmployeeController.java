package com.coldie.mysqlapp.controller;

import com.coldie.mysqlapp.model.Employee;
import com.coldie.mysqlapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> getAllEmployees() {
        return employeeService.findAllEmployees();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        Employee employee =  employeeService.findEmployeeById(id);
        if (employee == null) {
            throw new RuntimeException("Employee with id " + id + " is not found.");
        } else {
            return employee;
        }
    }

    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employee/{id}")
    public Employee deleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.findEmployeeById(id);
        employeeService.deleteEmployee(id);
        return employee;
    }
}
