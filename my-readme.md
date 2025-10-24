# Employee Management REST API

This project is a Spring Boot application that provides a REST API for managing employee data. It simulates a database using an in-memory data store and exposes endpoints to retrieve all employees, retrieve an employee by UUID, and create a new employee.

## Project Structure

### 1. `EntryLevelJavaChallengeApplication.java`
- The main entry point of the Spring Boot application.
- Starts the embedded server and initializes the application context.

### 2. `Employee.java`
- An interface that defines the contract for the `Employee` domain model.
- Specifies the methods that all employee implementations must provide, such as getters and setters for employee attributes.

### 3. `SimpleEmployee.java`
- A concrete implementation of the `Employee` interface.
- Represents an employee with attributes like UUID, name, salary, age, job title, email, and contract dates.

### 4. `MockEmployees.java`
- A utility class that simulates a database using an in-memory `HashMap`.
- Pre-populates the mock data store with sample employee records.
- Provides a helper method to add employees to the mock store.

### 5. `EmployeeService.java`
- A service class that contains the business logic for managing employees.
- Provides methods to:
    - Retrieve all employees.
    - Retrieve an employee by UUID.
    - Create a new employee.

### 6. `EmployeeController.java`
- A REST controller that exposes the API endpoints for managing employees.
- Endpoints:
    - `GET /api/v1/employee` - Retrieve all employees.
    - `GET /api/v1/employee/{uuid}` - Retrieve an employee by UUID.
    - `POST /api/v1/employee` - Create a new employee.

## How the Files Work Together

1. **Controller Layer (`EmployeeController`)**:
    - Handles HTTP requests and maps them to service methods.
    - Uses `EmployeeService` to perform business logic.

2. **Service Layer (`EmployeeService`)**:
    - Contains the core business logic for managing employees.
    - Interacts with the data layer (`MockEmployees`) to retrieve and manipulate employee data.

3. **Data Layer (`MockEmployees`)**:
    - Simulates a database using an in-memory `HashMap`.
    - Stores employee data and provides methods to add and retrieve employees.

4. **Model Layer (`Employee` and `SimpleEmployee`)**:
    - Defines the structure of employee data.
    - `Employee` is the interface, and `SimpleEmployee` is its implementation.

## Using the API with Postman (How to run)

- **First go to api->src->main->java->com.challenge.api and run the EntryLevelJavaChallengeApplication**
- Then open Postman to test the following endpoints:

### Base URL
http://localhost:8080/api/v1/employee

### Endpoints


#### 1. **Retrieve All Employees**
- **Method**: `GET`
- **URL**: `/`
- **Description**: Returns a list of all employees.
- **Response**:
  ```json
    {
      "uuid": "123e4567-e89b-12d3-a456-426614174000",
      "firstName": "Ada",
      "lastName": "Lovelace",
      "fullName": "Ada Lovelace",
      "email": "ada@example.com",
      "jobTitle": "Staff Engineer",
      "salary": 250000,
      "age": 36,
      "contractHireDate": "2020-01-01T00:00:00Z",
      "contractTerminationDate": null
    }

#### 2. **Retrieve an Employee by UUID**
- **Method**: `GET`
- **URL**: `/{uuid}`
- **Description**: Returns the details of an employee with the specified UUID.
- **Path Variable**:
   - `uuid` (required): The UUID of the employee.
- **Response**:
  ```json
       {
       "uuid": "123e4567-e89b-12d3-a456-426614174000",
       "firstName": "Ada",
       "lastName": "Lovelace",
       "fullName": "Ada Lovelace",
       "email": "ada@example.com",
       "jobTitle": "Staff Engineer",
       "salary": 250000,
       "age": 36,
       "contractHireDate": "2020-01-01T00:00:00Z",
       "contractTerminationDate": null
       }

#### 3. **Create a New Employee**
- **Method**: `POST`
- **URL**: `/`
- **Description**: Creates a new employee and adds them to the mock data store.
- **Headers**:
  - `Content-Type: application/json`
- **Request Body**:
  ```json
    {
      "firstName": "John",
      "lastName": "Doe",
      "email": "john.doe@example.com",
      "jobTitle": "Software Engineer",
      "salary": 120000,
      "age": 30
    }
  
- **Response**:
  ```json
    {
      "uuid": "123e4567-e89b-12d3-a456-426614174001",
      "firstName": "John",
      "lastName": "Doe",
      "fullName": "John Doe",
      "email": "john.doe@example.com",
      "jobTitle": "Software Engineer",
      "salary": 120000,
      "age": 30,
      "contractHireDate": "2023-10-01T12:00:00Z",
      "contractTerminationDate": null
    }

## Error Handling

- **404 Not Found**: Returned when an employee with the specified UUID does not exist.
- **400 Bad Request**: Returned when required fields are missing in the request body.

## Running the Application

### Start the Application
- Run the `EntryLevelJavaChallengeApplication` class.
- The application will start on `http://localhost:8080`.

### Test the Endpoints
- Use Postman to send requests to the API.
- Refer to the endpoint details above for the correct URLs and request formats.

### Code Formatting
- Use the Gradle task `spotlessApply` to format the code:
  ```bash
  ./gradlew spotlessApply

### Validate the Code Formatting
- Validate the code formatting with:
  ```bash
  ./gradlew build

## Notes

- This project uses an in-memory data store (`MockEmployees`) for simplicity. Data will be reset when the application restarts.
- The API is designed for demonstration purposes and does not include authentication or advanced error handling.