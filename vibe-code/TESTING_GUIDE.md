# Testing Guide for Class Manager Application

This guide provides instructions and examples for testing the Spring Boot Class Manager API.

## 📚 Testing Levels

### 1. Unit Tests
Test individual components in isolation

### 2. Integration Tests
Test multiple components working together

### 3. API Tests
Test HTTP endpoints with real requests

## 🧪 Setting Up Test Dependencies

Add to `pom.xml`:

```xml
<!-- Spring Boot Test Starter (includes JUnit, Mockito) -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
```

## 📝 Example Unit Test for TeacherService

Create file: `src/test/java/com/example/vibe_code/service/TeacherServiceTests.java`

```java
package com.example.vibe_code.service;

import com.example.vibe_code.model.Teacher;
import com.example.vibe_code.repository.TeacherRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TeacherServiceTests {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private TeacherRepository teacherRepository;

    @BeforeEach
    void setUp() {
        teacherRepository.deleteAll();
    }

    @Test
    void testCreateTeacher() {
        // Arrange
        Teacher teacher = new Teacher("John", "Doe", "john@school.com", "Math", "Science");

        // Act
        Teacher created = teacherService.createTeacher(teacher);

        // Assert
        assertNotNull(created.getId());
        assertEquals("John", created.getFirstName());
        assertEquals("john@school.com", created.getEmail());
    }

    @Test
    void testGetTeacherById() {
        // Arrange
        Teacher teacher = new Teacher("Jane", "Smith", "jane@school.com", "English", "Language Arts");
        Teacher saved = teacherService.createTeacher(teacher);

        // Act
        Optional<Teacher> found = teacherService.getTeacherById(saved.getId());

        // Assert
        assertTrue(found.isPresent());
        assertEquals("Jane", found.get().getFirstName());
    }

    @Test
    void testUpdateTeacher() {
        // Arrange
        Teacher teacher = new Teacher("Bob", "Johnson", "bob@school.com", "Physics", "Science");
        Teacher saved = teacherService.createTeacher(teacher);
        Teacher updated = new Teacher("Bob", "Johnson", "bob@school.com", "Advanced Physics", "Science");

        // Act
        Optional<Teacher> result = teacherService.updateTeacher(saved.getId(), updated);

        // Assert
        assertTrue(result.isPresent());
        assertEquals("Advanced Physics", result.get().getSubject());
    }

    @Test
    void testDeleteTeacher() {
        // Arrange
        Teacher teacher = new Teacher("Alice", "Brown", "alice@school.com", "Chemistry", "Science");
        Teacher saved = teacherService.createTeacher(teacher);

        // Act
        boolean deleted = teacherService.deleteTeacher(saved.getId());

        // Assert
        assertTrue(deleted);
        assertTrue(teacherService.getTeacherById(saved.getId()).isEmpty());
    }

    @Test
    void testGetTeacherByEmail() {
        // Arrange
        Teacher teacher = new Teacher("Mike", "Wilson", "mike@school.com", "History", "Social Studies");
        teacherService.createTeacher(teacher);

        // Act
        Optional<Teacher> found = teacherService.getTeacherByEmail("mike@school.com");

        // Assert
        assertTrue(found.isPresent());
        assertEquals("Mike", found.get().getFirstName());
    }
}
```

## 🌐 Example Integration Test for TeacherController

Create file: `src/test/java/com/example/vibe_code/controller/TeacherControllerTests.java`

```java
package com.example.vibe_code.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class TeacherControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetAllTeachersEndpoint() throws Exception {
        mockMvc.perform(get("/teachers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", isA(java.util.ArrayList.class)));
    }

    @Test
    void testCreateNewTeacherEndpoint() throws Exception {
        String newTeacher = """
                {
                    "firstName":"Robert",
                    "lastName":"Wilson",
                    "email":"robert.wilson@school.com",
                    "subject":"Chemistry",
                    "department":"Science"
                }
                """;

        mockMvc.perform(post("/teachers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newTeacher))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", notNullValue()))
                .andExpect(jsonPath("$.firstName", is("Robert")));
    }

    @Test
    void testUpdateTeacherEndpoint() throws Exception {
        String newTeacher = """
                {
                    "firstName":"John",
                    "lastName":"Doe",
                    "email":"john.doe@school.com",
                    "subject":"Math",
                    "department":"Science"
                }
                """;

        mockMvc.perform(post("/teachers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newTeacher))
                .andExpect(status().isCreated());

        String updatedTeacher = """
                {
                    "firstName":"John",
                    "lastName":"Doe",
                    "email":"john.doe@school.com",
                    "subject":"Advanced Mathematics",
                    "department":"Science"
                }
                """;

        mockMvc.perform(put("/teachers/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedTeacher))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.subject", is("Advanced Mathematics")));
    }

    @Test
    void testDeleteTeacherEndpoint() throws Exception {
        mockMvc.perform(delete("/teachers/999"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testGetNonExistentTeacherReturns404() throws Exception {
        mockMvc.perform(get("/teachers/999"))
                .andExpect(status().isNotFound());
    }
}
```

## 🌐 Example Integration Test for StudentController

Create file: `src/test/java/com/example/vibe_code/controller/StudentControllerTests.java`

```java
package com.example.vibe_code.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetAllStudentsEndpoint() throws Exception {
        mockMvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", isA(java.util.ArrayList.class)));
    }

    @Test
    void testCreateNewStudentEndpoint() throws Exception {
        String newStudent = """
                {
                    "firstName":"Emma",
                    "lastName":"Brown",
                    "email":"emma.brown@student.com",
                    "enrollmentDate":"2024-09-01",
                    "gradeLevel":"9",
                    "phoneNumber":"555-0103"
                }
                """;

        mockMvc.perform(post("/students")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newStudent))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", notNullValue()))
                .andExpect(jsonPath("$.firstName", is("Emma")));
    }

    @Test
    void testUpdateStudentEndpoint() throws Exception {
        String newStudent = """
                {
                    "firstName":"Michael",
                    "lastName":"Johnson",
                    "email":"michael.johnson@student.com",
                    "enrollmentDate":"2024-09-01",
                    "gradeLevel":"10",
                    "phoneNumber":"555-0101"
                }
                """;

        mockMvc.perform(post("/students")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newStudent))
                .andExpect(status().isCreated());

        String updatedStudent = """
                {
                    "firstName":"Michael",
                    "lastName":"Johnson",
                    "email":"michael.johnson@student.com",
                    "enrollmentDate":"2024-09-01",
                    "gradeLevel":"11",
                    "phoneNumber":"555-0101"
                }
                """;

        mockMvc.perform(put("/students/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedStudent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.gradeLevel", is("11")));
    }

    @Test
    void testDeleteStudentEndpoint() throws Exception {
        mockMvc.perform(delete("/students/999"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testGetNonExistentStudentReturns404() throws Exception {
        mockMvc.perform(get("/students/999"))
                .andExpect(status().isNotFound());
    }
}
```

## 🧬 Testing with curl

### Run tests from command line:

```bash
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=ClassRoomServiceTests

# Run specific test method
mvn test -Dtest=ClassRoomServiceTests#testGetAllClassesReturnsInitialClasses

# Run tests with coverage report
mvn test jacoco:report
```

## 📊 Manual Testing with curl

```bash
# Test GET all teachers
curl -X GET http://localhost:8080/teachers

# Test GET specific teacher
curl -X GET http://localhost:8080/teachers/1

# Test POST (create teacher)
curl -X POST http://localhost:8080/teachers \
  -H "Content-Type: application/json" \
  -d '{
    "firstName":"Sarah",
    "lastName":"Davis",
    "email":"sarah.davis@school.com",
    "subject":"Biology",
    "department":"Science"
  }'

# Test PUT (update teacher)
curl -X PUT http://localhost:8080/teachers/1 \
  -H "Content-Type: application/json" \
  -d '{
    "firstName":"John",
    "lastName":"Doe",
    "email":"john.doe@school.com",
    "subject":"Advanced Math",
    "department":"Science"
  }'

# Test DELETE teacher
curl -X DELETE http://localhost:8080/teachers/1

# Test GET all students
curl -X GET http://localhost:8080/students

# Test GET specific student
curl -X GET http://localhost:8080/students/1

# Test POST (create student)
curl -X POST http://localhost:8080/students \
  -H "Content-Type: application/json" \
  -d '{
    "firstName":"James",
    "lastName":"Anderson",
    "email":"james.anderson@student.com",
    "enrollmentDate":"2024-09-01",
    "gradeLevel":"10",
    "phoneNumber":"555-0105"
  }'

# Test PUT (update student)
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

# Test DELETE student
curl -X DELETE http://localhost:8080/students/1
```

## ✅ Test Coverage Checklist

Teacher Tests:
- [ ] Get all teachers
- [ ] Get specific teacher by ID
- [ ] Create new teacher
- [ ] Update existing teacher
- [ ] Delete teacher
- [ ] Handle 404 for non-existent teacher
- [ ] Validate email uniqueness
- [ ] Test required fields

Student Tests:
- [ ] Get all students
- [ ] Get specific student by ID
- [ ] Create new student
- [ ] Update existing student
- [ ] Delete student
- [ ] Handle 404 for non-existent student
- [ ] Validate email uniqueness
- [ ] Test date validation
- [ ] Test required fields

General:
- [ ] HTTP status codes (200, 201, 204, 404)
- [ ] Response formats (JSON structure)
- [ ] Database persistence
- [ ] Service layer logic
- [ ] Repository queries

## 🔍 Debugging Tests

### Print test information:
```java
@Test
void testSomething() {
    System.out.println("Starting test...");
    // test code
    System.out.println("Test completed!");
}
```

### Add debug breakpoints in IDE:
1. Click on line number
2. Run tests in debug mode
3. Inspect variables

## 📈 Test Organization

```
src/test/java/
├── com/example/vibe_code/
│   ├── controller/
│   │   └── ClassRoomControllerTests.java
│   ├── service/
│   │   └── ClassRoomServiceTests.java
│   ├── model/
│   │   └── ClassRoomTests.java
│   └── integration/
│       └── EndToEndTests.java
```

## 🎯 Best Practices

✅ **DO:**
- Write tests before or with code
- Use descriptive test names
- Test one thing per test
- Use @BeforeEach for setup
- Keep tests independent
- Verify both success and failure cases

❌ **DON'T:**
- Depend on test execution order
- Test multiple things in one test
- Skip error cases
- Hardcode values
- Make external API calls in tests
- Leave commented-out tests

## 📚 Resources

- [JUnit 5 Documentation](https://junit.org/junit5/docs/current/user-guide/)
- [Spring Boot Testing](https://spring.io/guides/gs/testing-web/)
- [Mockito Documentation](https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html)
- [REST Assured Testing](https://rest-assured.io/)

---

**Remember**: Good tests make your code reliable and maintainable. Aim for >80% code coverage!





