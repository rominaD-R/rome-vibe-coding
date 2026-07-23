# Teacher and Student Management System - Spring Boot REST API

A collaborative Spring Boot project for managing teachers and students with MySQL database integration and REST API endpoints.

## 🎯 Project Overview

This application provides a complete REST API for managing teachers and students in an educational setting. It demonstrates:
- Spring Boot REST API development with MySQL
- Spring Data JPA for database operations
- Collaborative Git/GitHub workflow
- GitHub Copilot-assisted code generation
- Layered architecture (Controller → Service → Repository → Model)
- CRUD operations with proper HTTP status codes

## 📁 Project Structure

```
vibe-code/
├── src/
│   ├── main/
│   │   ├── java/com/example/vibe_code/
│   │   │   ├── VibeCodeApplication.java           # Main Spring Boot application
│   │   │   ├── controller/
│   │   │   │   ├── TeacherController.java         # Teacher REST endpoints
│   │   │   │   └── StudentController.java         # Student REST endpoints
│   │   │   ├── service/
│   │   │   │   ├── TeacherService.java            # Teacher business logic
│   │   │   │   └── StudentService.java            # Student business logic
│   │   │   ├── repository/
│   │   │   │   ├── TeacherRepository.java         # Teacher data access
│   │   │   │   └── StudentRepository.java         # Student data access
│   │   │   └── model/
│   │   │       ├── Teacher.java                   # Teacher entity
│   │   │       └── Student.java                   # Student entity
│   │   └── resources/
│   │       └── application.properties             # Database configuration
│   └── test/
│       └── java/...                               # Unit tests
├── pom.xml                                        # Maven dependencies
├── API_DOCUMENTATION.md                           # API endpoint documentation
├── README.md                                      # This file
├── GIT_COLLABORATION_GUIDE.md                     # Git workflow guide
├── TESTING_GUIDE.md                               # Testing instructions
└── QUICK_REFERENCE.md                             # Quick command reference
```

## 🚀 Getting Started

### Prerequisites
- Java 11 or higher
- Maven 3.6+
- Git
- MySQL database server

### Installation

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd vibe-code
   ```

2. **Setup MySQL Database**
   
   Start MySQL:
   ```bash
   # macOS with Homebrew
   brew services start mysql
   
   # Or manually
   mysql.server start
   ```
   
   Create database:
   ```bash
   mysql -u root -p
   ```
   
   In MySQL prompt:
   ```sql
   CREATE DATABASE vibe_code_db;
   EXIT;
   ```

3. **Update Database Credentials** (if needed)
   
   Edit `src/main/resources/application.properties`:
   ```properties
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

4. **Build the project**
   ```bash
   mvn clean install
   ```

5. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

   The API will start on `http://localhost:8080`

## 📚 API Endpoints

### Base URLs
```
Teachers: http://localhost:8080/teachers
Students: http://localhost:8080/students
```

### Teachers Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/teachers` | Get all teachers |
| GET | `/teachers/{id}` | Get a specific teacher by ID |
| POST | `/teachers` | Create a new teacher |
| PUT | `/teachers/{id}` | Update an existing teacher |
| DELETE | `/teachers/{id}` | Delete a teacher by ID |

### Students Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/students` | Get all students |
| GET | `/students/{id}` | Get a specific student by ID |
| POST | `/students` | Create a new student |
| PUT | `/students/{id}` | Update an existing student |
| DELETE | `/students/{id}` | Delete a student by ID |

For detailed API documentation with examples, see [API_DOCUMENTATION.md](API_DOCUMENTATION.md)

## 🧪 Testing the API

### Using curl

```bash
# Get all classes
curl http://localhost:8080/api/classes

# Create a new class
curl -X POST http://localhost:8080/api/classes \
  -H "Content-Type: application/json" \
  -d '{"name":"React","instructor":"Emma","studentCount":18,"schedule":"MWF 2:00-3:30"}'

# Update a class
curl -X PUT http://localhost:8080/api/classes/1 \
  -H "Content-Type: application/json" \
  -d '{"name":"Java Advanced","instructor":"John Doe","studentCount":28,"schedule":"MWF 9:00-10:00"}'

# Delete a class
curl -X DELETE http://localhost:8080/api/classes/1
```

### Using Postman
1. Import the API endpoints into Postman
2. Test each endpoint with different HTTP methods
3. Verify responses and status codes

## 👥 Collaboration Guidelines

### Git Workflow

1. **Create a feature branch**
   ```bash
   git checkout -b feature/your-feature-name
   ```

2. **Make your changes**
   ```bash
   git add .
   git commit -m "Add: brief description of changes"
   ```

3. **Push to GitHub**
   ```bash
   git push origin feature/your-feature-name
   ```

4. **Create a Pull Request**
   - Go to GitHub and create a PR
   - Add a description of your changes
   - Request code review from teammates
   - Merge after approval

### Commit Message Convention
```
[Type]: Description
Types: Add, Fix, Update, Refactor, Test, Docs
Example: "Add: New endpoint for student enrollment"
```

## 🤖 Using GitHub Copilot

GitHub Copilot has been used to help generate and improve this codebase. Tips for using Copilot:

1. **Code Generation**: Start typing a function signature and Copilot will suggest implementations
2. **Comments**: Write clear comments describing what you want, and Copilot can generate code
3. **Tests**: Copilot can help generate unit and integration tests
4. **Documentation**: Use Copilot to help write API documentation and comments

Example workflow:
```java
// Copilot can complete this:
public ResponseEntity<?> someEndpoint() {
    // Start typing and Copilot will suggest the implementation
}
```

## 🏗️ Architecture

### Model Layer
- `Teacher`: Represents a teacher with ID, name, email, subject, and department
- `Student`: Represents a student with ID, name, email, enrollment date, grade level, and phone

### Repository Layer
- `TeacherRepository`: Spring Data JPA interface for teacher database operations
- `StudentRepository`: Spring Data JPA interface for student database operations

### Service Layer
- `TeacherService`: Handles teacher business logic
  - CRUD operations
  - Database interactions via repository
  
- `StudentService`: Handles student business logic
  - CRUD operations
  - Database interactions via repository

### Controller Layer
- `TeacherController`: REST endpoints for teacher management
  - Maps HTTP requests to service methods
  - Handles responses with appropriate status codes
  - Includes CORS configuration

- `StudentController`: REST endpoints for student management
  - Maps HTTP requests to service methods
  - Handles responses with appropriate status codes
  - Includes CORS configuration

## 📝 Database Configuration

### Application Properties
File: `src/main/resources/application.properties`

```properties
# MySQL Connection
spring.datasource.url=jdbc:mysql://localhost:3306/vibe_code_db
spring.datasource.username=root
spring.datasource.password=root

# JPA/Hibernate
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=false
```

## 📊 Database Schema

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

## 🚨 Error Handling

The API returns appropriate HTTP status codes:

- `200 OK`: Successful GET, PUT request
- `201 Created`: Successful POST request
- `204 No Content`: Successful DELETE request
- `400 Bad Request`: Invalid request data
- `404 Not Found`: Resource not found
- `500 Internal Server Error`: Server error

## 📚 Extending the Application

### Adding a New Field to Teacher

1. Add field to `Teacher` model in `src/main/java/.../model/Teacher.java`
2. Add getter and setter methods
3. The database migration is handled automatically by Hibernate

Example:
```java
@Column
private String phoneNumber;

public String getPhoneNumber() {
    return phoneNumber;
}

public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
}
```

### Adding a Custom Query

1. Add method to repository interface:
```java
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findByDepartment(String department);
}
```

2. Add method to service:
```java
public List<Teacher> getTeachersByDepartment(String department) {
    return teacherRepository.findByDepartment(department);
}
```

3. Add endpoint to controller:
```java
@GetMapping("/by-department/{department}")
public ResponseEntity<List<Teacher>> getTeachersByDepartment(
        @PathVariable String department) {
    return ResponseEntity.ok(teacherService.getTeachersByDepartment(department));
}
```

## 📖 Resources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring REST Docs](https://spring.io/projects/spring-restdocs)
- [REST API Best Practices](https://restfulapi.net/)
- [GitHub Copilot Documentation](https://github.com/features/copilot)

## 👨‍💻 Team Members

Add your team members here:
- Member 1: [Name]
- Member 2: [Name]
- Member 3: [Name]
- Member 4: [Name]

## 📝 License

This project is part of the LaunchCode Unit 2 curriculum.

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

---

**Last Updated**: July 22, 2026
**Version**: 1.0









