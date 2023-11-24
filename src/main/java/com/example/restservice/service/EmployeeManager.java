package com.example.restservice.service;

import org.springframework.stereotype.Service;

import com.example.restservice.model.Employee;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeManager {
    private List<Employee> employees = new ArrayList<>();

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }
}
