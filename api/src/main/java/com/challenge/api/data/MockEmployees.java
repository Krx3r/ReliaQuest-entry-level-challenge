package com.challenge.api.data;

import com.challenge.api.model.Employee;
import com.challenge.api.model.SimpleEmployee;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class MockEmployees {
    public static final Map<UUID, Employee> MOCK_STORE = new HashMap<>();

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
