package com.challenge.api.controller;

import com.challenge.api.model.Employee;
import com.challenge.api.model.SimpleEmployee;
import com.challenge.api.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Retrieve all employees.
     * @return List of all employees.
     */
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    /**
     * Retrieve an employee by UUID.
     * @param uuid Employee UUID.
     * @return Employee if found, otherwise 404.
     */
    @GetMapping("/{uuid}")
    public ResponseEntity<Employee> getEmployeeByUuid(@PathVariable UUID uuid) {
        try {
            Employee employee = employeeService.getEmployeeByUuid(uuid);
            return ResponseEntity.ok(employee);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    /**
     * Create a new employee.
     * @param newEmployee Employee details from the request body.
     * @return Newly created employee.
     */
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody SimpleEmployee newEmployee) {
        if (newEmployee.getFirstName() == null || newEmployee.getLastName() == null || newEmployee.getEmail() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing required fields");
        }
        Employee createdEmployee = employeeService.createEmployee(newEmployee);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
    }
}