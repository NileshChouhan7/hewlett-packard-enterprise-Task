package com.example.restservice.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.restservice.model.Employee;
import com.example.restservice.service.EmployeeManager;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeControllerTest {

    @InjectMocks
    private EmployeeController employeeController;

    @Mock
    private EmployeeManager employeeManager;

    @BeforeEach
    public void initialize() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testGetAllEmployees() {
        List<Employee> employees = Arrays.asList(
            new Employee("1", "John", "Doe", "john@example.com", "Manager"),
            new Employee("2", "Jane", "Smith", "jane@example.com", "Developer")
        );

        Mockito.when(employeeManager.getAllEmployees()).thenReturn(employees);

        ResponseEntity<List<Employee>> response = employeeController.getAllEmployees();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(employees, response.getBody());
    }

    @Test
    public void testAddEmployee() {
        Employee newEmployee = new Employee("3", "Alice", "Johnson", "alice@example.com", "Designer");

        Mockito.when(employeeManager.addEmployee(newEmployee)).thenReturn(newEmployee);

        ResponseEntity<Employee> response = employeeController.addEmployee(newEmployee);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(newEmployee, response.getBody());
    }
}
