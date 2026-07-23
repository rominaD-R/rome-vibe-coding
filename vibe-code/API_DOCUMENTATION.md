# Class Manager API Documentation

## Overview
This is a Spring Boot REST API for managing classes, instructors, and student information.

## Base URL
```
http://localhost:8080/api/classes
```

## Teachers Endpoints

### 1. Get All Teachers
**Request:**
```
GET /teachers
```

**Response (200 OK):**
```json
[
  {
    "id": 1,
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@school.com",
    "subject": "Mathematics",
    "department": "Science"
  },
  {
    "id": 2,
    "firstName": "Jane",
    "lastName": "Smith",
    "email": "jane.smith@school.com",
    "subject": "English",
    "department": "Language Arts"
  }
]
```

---

### 2. Get Teacher by ID
**Request:**
```
GET /teachers/{id}
```

**Example:**
```
GET /teachers/1
```

**Response (200 OK):**
```json
{
  "id": 1,
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@school.com",
  "subject": "Mathematics",
  "department": "Science"
}
```

**Response (404 Not Found):** If the teacher ID does not exist

---

### 3. Create a New Teacher
**Request:**
```
POST /teachers
Content-Type: application/json

{
  "firstName": "Alice",
  "lastName": "Williams",
  "email": "alice.williams@school.com",
  "subject": "Physics",
  "department": "Science"
}
```

**Response (201 Created):**
```json
{
  "id": 3,
  "firstName": "Alice",
  "lastName": "Williams",
  "email": "alice.williams@school.com",
  "subject": "Physics",
  "department": "Science"
}
```

---

### 4. Update an Existing Teacher
**Request:**
```
PUT /teachers/{id}
Content-Type: application/json

{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@school.com",
  "subject": "Advanced Mathematics",
  "department": "Science"
}
```

**Example:**
```
PUT /teachers/1
```

**Response (200 OK):**
```json
{
  "id": 1,
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@school.com",
  "subject": "Advanced Mathematics",
  "department": "Science"
}
```

**Response (404 Not Found):** If the teacher ID does not exist

---

### 5. Delete a Teacher
**Request:**
```
DELETE /teachers/{id}
```

**Example:**
```
DELETE /teachers/1
```

**Response (204 No Content):** If deletion is successful

**Response (404 Not Found):** If the teacher ID does not exist

---

## Students Endpoints

### 1. Get All Students
**Request:**
```
GET /students
```

**Response (200 OK):**
```json
[
  {
    "id": 1,
    "firstName": "Michael",
    "lastName": "Johnson",
    "email": "michael.johnson@student.com",
    "enrollmentDate": "2024-09-01",
    "gradeLevel": "10",
    "phoneNumber": "555-0101"
  },
  {
    "id": 2,
    "firstName": "Sarah",
    "lastName": "Williams",
    "email": "sarah.williams@student.com",
    "enrollmentDate": "2024-09-01",
    "gradeLevel": "11",
    "phoneNumber": "555-0102"
  }
]
```

---

### 2. Get Student by ID
**Request:**
```
GET /students/{id}
```

**Example:**
```
GET /students/1
```

**Response (200 OK):**
```json
{
  "id": 1,
  "firstName": "Michael",
  "lastName": "Johnson",
  "email": "michael.johnson@student.com",
  "enrollmentDate": "2024-09-01",
  "gradeLevel": "10",
  "phoneNumber": "555-0101"
}
```

**Response (404 Not Found):** If the student ID does not exist

---

### 3. Create a New Student
**Request:**
```
POST /students
Content-Type: application/json

{
  "firstName": "Emma",
  "lastName": "Brown",
  "email": "emma.brown@student.com",
  "enrollmentDate": "2024-09-15",
  "gradeLevel": "9",
  "phoneNumber": "555-0103"
}
```

**Response (201 Created):**
```json
{
  "id": 3,
  "firstName": "Emma",
  "lastName": "Brown",
  "email": "emma.brown@student.com",
  "enrollmentDate": "2024-09-15",
  "gradeLevel": "9",
  "phoneNumber": "555-0103"
}
```

---

### 4. Update an Existing Student
**Request:**
```
PUT /students/{id}
Content-Type: application/json

{
  "firstName": "Michael",
  "lastName": "Johnson",
  "email": "michael.johnson@student.com",
  "enrollmentDate": "2024-09-01",
  "gradeLevel": "11",
  "phoneNumber": "555-0101"
}
```

**Example:**
```
PUT /students/1
```

**Response (200 OK):**
```json
{
  "id": 1,
  "firstName": "Michael",
  "lastName": "Johnson",
  "email": "michael.johnson@student.com",
  "enrollmentDate": "2024-09-01",
  "gradeLevel": "11",
  "phoneNumber": "555-0101"
}
```

**Response (404 Not Found):** If the student ID does not exist

---

### 5. Delete a Student
**Request:**
```
DELETE /students/{id}
```

**Example:**
```
DELETE /students/1
```

**Response (204 No Content):** If deletion is successful

**Response (404 Not Found):** If the student ID does not exist

---

## Testing the API

### Using curl:

```bash
# Get all teachers
curl http://localhost:8080/teachers

# Get a specific teacher
curl http://localhost:8080/teachers/1

# Create a new teacher
curl -X POST http://localhost:8080/teachers \
  -H "Content-Type: application/json" \
  -d '{
    "firstName":"Robert",
    "lastName":"Wilson",
    "email":"robert.wilson@school.com",
    "subject":"Chemistry",
    "department":"Science"
  }'

# Update a teacher
curl -X PUT http://localhost:8080/teachers/1 \
  -H "Content-Type: application/json" \
  -d '{
    "firstName":"John",
    "lastName":"Doe",
    "email":"john.doe@school.com",
    "subject":"Advanced Mathematics",
    "department":"Science"
  }'

# Delete a teacher
curl -X DELETE http://localhost:8080/teachers/1

# Get all students
curl http://localhost:8080/students

# Get a specific student
curl http://localhost:8080/students/1

# Create a new student
curl -X POST http://localhost:8080/students \
  -H "Content-Type: application/json" \
  -d '{
    "firstName":"David",
    "lastName":"Lee",
    "email":"david.lee@student.com",
    "enrollmentDate":"2024-09-01",
    "gradeLevel":"9",
    "phoneNumber":"555-0104"
  }'

# Update a student
curl -X PUT http://localhost:8080/students/1 \
  -H "Content-Type: application/json" \
  -d '{
    "firstName":"Michael",
    "lastName":"Johnson",
    "email":"michael.johnson@student.com",
    "enrollmentDate":"2024-09-01",
    "gradeLevel":"11",
    "phoneNumber":"555-0101"
  }'

# Delete a student
curl -X DELETE http://localhost:8080/students/1
```

---

## Running the Application

### Prerequisites
- Java 11 or higher
- MySQL database running
- Maven

### Setup Database

1. **Start MySQL**
   ```bash
   # macOS with Homebrew
   brew services start mysql
   
   # Or manually
   mysql.server start
   ```

2. **Create database**
   ```bash
   mysql -u root -p
   ```
   
   In MySQL:
   ```sql
   CREATE DATABASE vibe_code_db;
   EXIT;
   ```

### Build and Run

```bash
# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`

---

## Database Schema

### Teachers Table
```sql
CREATE TABLE teachers (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL UNIQUE,
  subject VARCHAR(255) NOT NULL,
  department VARCHAR(255)
);
```

### Students Table
```sql
CREATE TABLE students (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL UNIQUE,
  enrollment_date DATE NOT NULL,
  grade_level VARCHAR(255) NOT NULL,
  phone_number VARCHAR(255)
);
```

---

## Technologies Used
- Spring Boot
- Spring Web (REST API)
- Java 11+
- Maven





