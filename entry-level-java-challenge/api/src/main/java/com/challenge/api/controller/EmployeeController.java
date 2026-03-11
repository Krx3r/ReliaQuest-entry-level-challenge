// package com.challenge.api.controller;
//
// import com.challenge.api.data.MockEmployees;
// import com.challenge.api.model.Employee;
// import com.challenge.api.model.SimpleEmployee;
// import com.challenge.api.service.EmployeeService;
// import java.util.List;
// import java.util.UUID;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;
// import org.springframework.web.server.ResponseStatusException;
//
// @RestController
// @RequestMapping("/api/v1/employee")
// public class EmployeeController {
//
//    private final EmployeeService employeeService;
//
//    public EmployeeController(EmployeeService employeeService) {
//        this.employeeService = employeeService;
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Employee>> getAllEmployees() {
//        List<Employee> employees = employeeService.getAllEmployees();
//        return ResponseEntity.ok(employees);
//    }
//
//    @GetMapping("/{uuid}")
//    public ResponseEntity<Employee> getEmployeeByUuid(@PathVariable String uuid) {
//        // Regular expression to validate UUID format
//        String uuidRegex =
// "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[1-5][0-9a-fA-F]{3}-[89abAB][0-9a-fA-F]{3}-[0-9a-fA-F]{12}$";
//        if (!uuid.matches(uuidRegex)) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid UUID format");
//        }
//        try {
//            Employee employee = employeeService.getEmployeeByUuid(UUID.fromString(uuid));
//            return ResponseEntity.ok(employee);
//        } catch (IllegalArgumentException e) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found for the provided UUID.");
//        }
//    }
//
//    @PostMapping
//    public ResponseEntity<Employee> createEmployee(@RequestBody SimpleEmployee newEmployee) {
//        if (newEmployee.getFirstName() == null || newEmployee.getLastName() == null || newEmployee.getEmail() == null)
// {
//            throw new ResponseStatusException(
//                    HttpStatus.BAD_REQUEST, "Missing required fields: firstName, lastName, or email.");
//        }
//        if (newEmployee.getJobTitle() == null || newEmployee.getSalary() == null || newEmployee.getAge() == null) {
//            throw new ResponseStatusException(
//                    HttpStatus.BAD_REQUEST, "Missing required fields: jobTitle, salary, or age.");
//        }
//        // Check for duplicate email
//        boolean emailExists = MockEmployees.MOCK_STORE.values().stream()
//                .map(employee -> (Employee) employee) // Cast to Employee
//                .anyMatch(employee -> employee.getEmail().equalsIgnoreCase(newEmployee.getEmail()));
//        if (emailExists) {
//            throw new ResponseStatusException(HttpStatus.CONFLICT, "An employee with the same email already exists.");
//        }
//        Employee createdEmployee = employeeService.createEmployee(newEmployee);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
//    }
// }

package com.challenge.api.controller;

import com.challenge.api.data.MockEmployees;
import com.challenge.api.model.Employee;
import com.challenge.api.model.SimpleEmployee;
import com.challenge.api.service.EmployeeService;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Employee> getEmployeeByUuid(@PathVariable String uuid) {
        // Regular expression to validate UUID format
        String uuidRegex = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[1-5][0-9a-fA-F]{3}-[89abAB][0-9a-fA-F]{3}-[0-9a-fA-F]{12}$";
        if (!uuid.matches(uuidRegex)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid UUID format");
        }
        try {
            Employee employee = employeeService.getEmployeeByUuid(UUID.fromString(uuid));
            return ResponseEntity.ok(employee);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found for the provided UUID.");
        }
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody SimpleEmployee newEmployee) {
        if (newEmployee.getFirstName() == null || newEmployee.getLastName() == null || newEmployee.getEmail() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Missing required fields: firstName, lastName, or email.");
        }
        if (newEmployee.getJobTitle() == null || newEmployee.getSalary() == null || newEmployee.getAge() == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Missing required fields: jobTitle, salary, or age.");
        }

        // Check for duplicate email using a loop
        for (Map.Entry<UUID, Employee> entry : MockEmployees.MOCK_STORE.entrySet()) {
            Employee employee = entry.getValue();
            if (employee.getEmail().equalsIgnoreCase(newEmployee.getEmail())) {
                throw new ResponseStatusException(
                        HttpStatus.CONFLICT, "An employee with the same email already exists.");
            }
        }

        Employee createdEmployee = employeeService.createEmployee(newEmployee);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
    }
}
