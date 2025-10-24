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

/**
 * Service class for managing employee-related business logic.
 * Provides methods to retrieve all employees, retrieve an employee by UUID, and create a new employee.
 */

@Service
public class EmployeeService {

    /**
     * Retrieve all employees from the mock data store.
     *
     * @return A list of all employees.
     */
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(MockEmployees.MOCK_STORE.values());
    }

    /**
     * Retrieve an employee by their UUID.
     *
     * @param uuid The UUID of the employee to retrieve.
     * @return The employee with the specified UUID.
     * @throws IllegalArgumentException if no employee is found for the given UUID.
     */
    public Employee getEmployeeByUuid(UUID uuid) {
        if (!MockEmployees.MOCK_STORE.containsKey(uuid)) {
            throw new IllegalArgumentException("Employee not found for UUID: " + uuid);
        }
        return MockEmployees.MOCK_STORE.get(uuid);
    }

    /**
     * Create a new employee and add them to the mock data store.
     *
     * @param newEmployee The employee details provided in the request.
     * @return The newly created employee.
     */
    public Employee createEmployee(SimpleEmployee newEmployee) {
        UUID uuid = UUID.randomUUID();
        newEmployee.setUuid(uuid);
        newEmployee.setFullName(newEmployee.getFirstName() + " " + newEmployee.getLastName());
        newEmployee.setContractHireDate(Instant.now()); // Set hire date to current timestamp
        MockEmployees.MOCK_STORE.put(uuid, newEmployee);
        return newEmployee;
    }
}
