package com.coldie.mysqlapp.dao;

import com.coldie.mysqlapp.model.Employee;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> findAllEmployees() {
        Session currenSession = entityManager.unwrap(Session.class);
        Query<Employee> query = currenSession.createQuery("from Employee", Employee.class);
        List<Employee> list = query.getResultList();
        return list;
    }

    @Override
    public Employee findEmployeeById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Employee employee = currentSession.get(Employee.class, id);
        return employee;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.save(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.update(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Employee employee = currentSession.get(Employee.class, id);
        currentSession.delete(employee);
    }
}
