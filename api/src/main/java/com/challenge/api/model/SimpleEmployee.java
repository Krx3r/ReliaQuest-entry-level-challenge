package com.challenge.api.model;

import java.time.Instant;
import java.util.UUID;

/**
 * SimpleEmployee is a concrete implementation of the Employee interface.
 * It represents an employee with attributes such as UUID, name, salary, age, job title, email, and contract dates.
 */


public class SimpleEmployee implements Employee {

    // Unique identifier for the employee
    private UUID uuid;

    // First name of the employee
    private String firstName;

    // Last name of the employee
    private String lastName;

    // Full name of the employee (first name + last name)
    private String fullName;

    // Salary of the employee
    private Integer salary;

    // Age of the employee
    private Integer age;

    // Job title of the employee
    private String jobTitle;

    // Email address of the employee
    private String email;

    // Contract hire date of the employee
    private Instant contractHireDate;

    // Contract termination date of the employee (nullable)
    private Instant contractTerminationDate;


    /**
     * Get the UUID of the employee.
     * @return UUID of the employee.
     */
    @Override public UUID getUuid() { return uuid; }

    /**
     * Set the UUID of the employee.
     * @param uuid Unique identifier for the employee (non-null).
     */
    @Override public void setUuid(UUID uuid) { this.uuid = uuid; }

    /**
     * Get the first name of the employee.
     * @return First name of the employee.
     */
    @Override public String getFirstName() { return firstName; }

    /**
     * Set the first name of the employee.
     * @param name First name of the employee.
     */
    @Override public void setFirstName(String name) { this.firstName = name; }

    /**
     * Get the last name of the employee.
     * @return Last name of the employee.
     */
    @Override public String getLastName() { return lastName; }

    /**
     * Set the last name of the employee.
     * @param name Last name of the employee.
     */
    @Override public void setLastName(String name) { this.lastName = name; }

    /**
     * Get the full name of the employee.
     * @return Full name of the employee.
     */
    @Override public String getFullName() { return fullName; }

    /**
     * Set the full name of the employee.
     * @param name Full name of the employee.
     */
    @Override public void setFullName(String name) { this.fullName = name; }

    /**
     * Get the salary of the employee.
     * @return Salary of the employee.
     */
    @Override public Integer getSalary() { return salary; }

    /**
     * Set the salary of the employee.
     * @param salary Salary of the employee.
     */
    @Override public void setSalary(Integer salary) { this.salary = salary; }


    /**
     * Get the age of the employee.
     * @return Age of the employee.
     */
    @Override public Integer getAge() { return age; }

    /**
     * Set the age of the employee.
     * @param age Age of the employee.
     */
    @Override public void setAge(Integer age) { this.age = age; }

    /**
     * Get the job title of the employee.
     * @return Job title of the employee.
     */
    @Override public String getJobTitle() { return jobTitle; }

    /**
     * Set the job title of the employee.
     * @param jobTitle Job title of the employee.
     */
    @Override public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }

    /**
     * Get the email address of the employee.
     * @return Email address of the employee.
     */
    @Override public String getEmail() { return email; }

    /**
     * Set the email address of the employee.
     * @param email Email address of the employee.
     */
    @Override public void setEmail(String email) { this.email = email; }

    /**
     * Get the contract hire date of the employee.
     * @return Contract hire date of the employee.
     */
    @Override public Instant getContractHireDate() { return contractHireDate; }

    /**
     * Set the contract hire date of the employee.
     * @param date Contract hire date of the employee.
     */
    @Override public void setContractHireDate(Instant date) { this.contractHireDate = date; }

    /**
     * Get the contract termination date of the employee.
     * @return Contract termination date of the employee, or null if not terminated.
     */
    @Override public Instant getContractTerminationDate() { return contractTerminationDate; }

    /**
     * Set the contract termination date of the employee.
     * @param date Contract termination date of the employee.
     */
    @Override public void setContractTerminationDate(Instant date) { this.contractTerminationDate = date; }
}