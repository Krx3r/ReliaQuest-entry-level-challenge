package com.challenge.api.service;

import com.challenge.api.data.MockEmployees;
import com.challenge.api.model.Employee;
import com.challenge.api.model.SimpleEmployee;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    // Retrieve all employees
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(MockEmployees.MOCK_STORE.values());
    }

    // Retrieve an employee by UUID
    public Employee getEmployeeByUuid(UUID uuid) {
        if (!MockEmployees.MOCK_STORE.containsKey(uuid)) {
            throw new IllegalArgumentException("Employee not found for UUID: " + uuid);
        }
        return MockEmployees.MOCK_STORE.get(uuid);
    }

    // Create a new employee
    public Employee createEmployee(SimpleEmployee newEmployee) {
        UUID uuid = UUID.randomUUID();
        newEmployee.setUuid(uuid);
        newEmployee.setFullName(newEmployee.getFirstName() + " " + newEmployee.getLastName());
        newEmployee.setContractHireDate(Instant.now()); // Set hire date to current timestamp
        MockEmployees.MOCK_STORE.put(uuid, newEmployee);
        return newEmployee;
    }
}
