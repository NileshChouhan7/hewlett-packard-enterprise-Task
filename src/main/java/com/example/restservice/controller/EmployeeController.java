package com.example.restservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.restservice.model.Employee;
import com.example.restservice.service.EmployeeManager;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeManager employeeManager;

    public EmployeeController(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeManager.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee addedEmployee = employeeManager.addEmployee(employee);
        return new ResponseEntity<>(addedEmployee, HttpStatus.CREATED);
    }
}
