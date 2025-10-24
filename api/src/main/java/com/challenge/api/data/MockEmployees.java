package com.challenge.api.data;

import com.challenge.api.model.Employee;
import com.challenge.api.model.SimpleEmployee;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * MockEmployees is a utility class that simulates a database for storing employee data.
 * It uses an in-memory HashMap to store employee records, pre-populated with sample data.
 */


public class MockEmployees {

    /**
     * A static in-memory store for employee data, where the key is the employee's UUID
     * and the value is the corresponding Employee object.
     */

    public static final Map<UUID, Employee> MOCK_STORE = new HashMap<>();

    // Static block to initialize the mock data store with sample employees.
    static {
        add("Ada", "Lovelace", "ada@example.com", "Staff Engineer", 250000, 36,
                Instant.parse("2020-01-01T00:00:00Z"));
        add("Grace", "Hopper", "grace@example.com", "Principal Engineer", 300000, 45,
                Instant.parse("2019-03-15T00:00:00Z"));
        add("Margaret", "Hamilton", "margaret@example.com", "Engineering Manager", 260000, 40,
                Instant.parse("2018-07-20T00:00:00Z"));
        add("Alan", "Turing", "alan@example.com", "Research Scientist", 220000, 41,
                Instant.parse("2017-05-10T00:00:00Z"));
        add("Katherine", "Johnson", "katherine@example.com", "Mathematician", 210000, 50,
                Instant.parse("2016-11-30T00:00:00Z"));
    }


    /**
     * Helper method to add a mock employee to the in-memory store.
     *
     * @param first     The first name of the employee.
     * @param last      The last name of the employee.
     * @param email     The email address of the employee.
     * @param jobTitle  The job title of the employee.
     * @param salary    The salary of the employee.
     * @param age       The age of the employee.
     * @param date      The contract hire date of the employee.
     */


    // Helper to add a mock employee
    private static void add(String first, String last, String email, String jobTitle, int salary, int age, Instant date) {
        UUID id = UUID.randomUUID();
        SimpleEmployee e = new SimpleEmployee();
        e.setUuid(id);
        e.setFirstName(first);
        e.setLastName(last);
        e.setFullName(first + " " + last);
        e.setEmail(email);
        e.setJobTitle(jobTitle);
        e.setSalary(salary);
        e.setAge(age);
        e.setContractHireDate(date);
        MOCK_STORE.put(id, e);
    }
}
