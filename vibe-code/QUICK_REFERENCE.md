# Quick Reference Card 🚀

## Project Setup & Running

```bash
# Clone the repository
git clone <url>
cd vibe-code

# Start MySQL
brew services start mysql

# Create database
mysql -u root -p
CREATE DATABASE vibe_code_db;
EXIT;

# Build and run
mvn clean install
mvn spring-boot:run

# Access the API
# http://localhost:8080/teachers
# http://localhost:8080/students
```

## 🔑 API Endpoints Quick Reference

### Teachers

| HTTP | URL | Purpose |
|------|-----|---------|
| GET | `/teachers` | Get all teachers |
| GET | `/teachers/1` | Get teacher with ID 1 |
| POST | `/teachers` | Create new teacher |
| PUT | `/teachers/1` | Update teacher with ID 1 |
| DELETE | `/teachers/1` | Delete teacher with ID 1 |

### Students

| HTTP | URL | Purpose |
|------|-----|---------|
| GET | `/students` | Get all students |
| GET | `/students/1` | Get student with ID 1 |
| POST | `/students` | Create new student |
| PUT | `/students/1` | Update student with ID 1 |
| DELETE | `/students/1` | Delete student with ID 1 |

## 📋 JSON Request Body Examples

### Teacher
```json
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "john.doe@school.com",
  "subject": "Mathematics",
  "department": "Science"
}
```

### Student
```json
{
  "firstName": "Michael",
  "lastName": "Johnson",
  "email": "michael.johnson@student.com",
  "enrollmentDate": "2024-09-01",
  "gradeLevel": "10",
  "phoneNumber": "555-0101"
}
```

## 💻 Common Commands

```bash
# Git commands
git checkout -b feature/new-feature    # Create feature branch
git add .                              # Stage changes
git commit -m "Add: description"       # Commit
git push origin feature/new-feature    # Push branch
git pull origin main                   # Get latest changes

# Maven commands
mvn clean install                      # Clean build
mvn spring-boot:run                    # Run application
mvn test                               # Run tests
mvn test -Dtest=ClassName             # Run specific test

# ...existing code...

# MySQL commands
brew services start mysql          # Start MySQL server
brew services stop mysql           # Stop MySQL server
mysql -u root -p                   # Connect to MySQL
# ...existing code...
```

## 📁 Project Structure

```
vibe-code/
├── src/main/java/com/example/vibe_code/
│   ├── VibeCodeApplication.java           ← Main entry point
│   ├── controller/
│   │   ├── TeacherController.java         ← Teacher endpoints
│   │   └── StudentController.java         ← Student endpoints
│   ├── service/
│   │   ├── TeacherService.java            ← Teacher logic
│   │   └── StudentService.java            ← Student logic
│   ├── repository/
│   │   ├── TeacherRepository.java         ← Database access
│   │   └── StudentRepository.java         ← Database access
│   └── model/
│       ├── Teacher.java                   ← Teacher entity
│       └── Student.java                   ← Student entity
├── README.md                          ← Project overview
├── API_DOCUMENTATION.md               ← Detailed API docs
├── GIT_COLLABORATION_GUIDE.md         ← Git workflow
├── TESTING_GUIDE.md                   ← Testing help
├── QUICK_REFERENCE.md                 ← This file
└── pom.xml                            ← Dependencies
```

## 🎯 Teacher Entity

```java
Teacher {
  Long id              // Auto-generated ID
  String firstName     // First name
  String lastName      // Last name
  String email         // Email (unique)
  String subject       // Subject taught
  String department    // Department
}
```

## 🎯 Student Entity

```java
Student {
  Long id              // Auto-generated ID
  String firstName     // First name
  String lastName      // Last name
  String email         // Email (unique)
  LocalDate enrollmentDate  // Enrollment date
  String gradeLevel    // Grade level
  String phoneNumber   // Phone number
}
```

## 🎯 Git Workflow (Step by Step)

```bash
# 1. Create feature branch
git checkout main
git pull origin main
git checkout -b feature/my-feature

# 2. Make changes & commit
git add .
git commit -m "Add: new feature"

# 3. Push & create PR
git push origin feature/my-feature

# 4. After PR approved, merge on GitHub

# 5. Update local main
git checkout main
git pull origin main
```

## 🧪 Testing Quick Start

```bash
# Run all tests
mvn test

# Run specific test
mvn test -Dtest=TeacherServiceTests

# Test with curl - Get all teachers
curl http://localhost:8080/teachers

# Test with curl - Create teacher
curl -X POST http://localhost:8080/teachers \
  -H "Content-Type: application/json" \
  -d '{
    "firstName":"John",
    "lastName":"Doe",
    "email":"john.doe@school.com",
    "subject":"Math",
    "department":"Science"
  }'

# Test with curl - Get all students
curl http://localhost:8080/students
```

## ✅ Code Review Checklist

Before pushing code:
- [ ] Code compiles without errors
- [ ] Changes follow project structure
- [ ] Commit message is descriptive
- [ ] Changes tested locally
- [ ] No debug code left behind
- [ ] Comments added where needed

## 📌 File Locations

| What | Where |
|------|-------|
| Teacher Model | `src/main/java/.../model/Teacher.java` |
| Student Model | `src/main/java/.../model/Student.java` |
| Teacher Service | `src/main/java/.../service/TeacherService.java` |
| Student Service | `src/main/java/.../service/StudentService.java` |
| Teacher Controller | `src/main/java/.../controller/TeacherController.java` |
| Student Controller | `src/main/java/.../controller/StudentController.java` |
| Teacher Repository | `src/main/java/.../repository/TeacherRepository.java` |
| Student Repository | `src/main/java/.../repository/StudentRepository.java` |
| Main App | `src/main/java/.../VibeCodeApplication.java` |
| Database Config | `src/main/resources/application.properties` |
| Tests | `src/test/java/.../` |

## 🔧 Database Configuration

File: `src/main/resources/application.properties`

```properties
# MySQL Connection
spring.datasource.url=jdbc:mysql://localhost:3306/vibe_code_db
spring.datasource.username=root
spring.datasource.password=root

# JPA/Hibernate
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
```

## 🆘 Troubleshooting

| Problem | Solution |
|---------|----------|
| Cannot connect to database | Check MySQL is running: `brew services start mysql` |
| Database not found | Create database: `mysql -u root -p` → `CREATE DATABASE vibe_code_db;` |
| Port already in use | Change `server.port` in `application.properties` |
| Tests fail | Run `mvn clean` first, then `mvn test` |
| Git merge conflict | Edit conflicting files, then `git add .` and `git commit` |
| Application won't start | Check Java version (need 11+): `java -version` |

## 📞 Team Resources

- **API Docs**: See `API_DOCUMENTATION.md`
- **Git Help**: See `GIT_COLLABORATION_GUIDE.md`
- **Testing**: See `TESTING_GUIDE.md`
- **Full README**: See `README.md`

## 🤖 GitHub Copilot Tips

Use Copilot to:
```java
// Write tests - describe what you want:
// "Test that getAllTeachers returns a list of teachers"
// Copilot will suggest test code

// Generate endpoints - start the method:
@GetMapping("/custom")
public ResponseEntity<?> customEndpoint() {
// Copilot suggests the implementation

// Create documentation - write comments:
// "Create endpoint for filtering teachers by department"
```

## 🚀 Deployment Checklist

- [ ] All tests pass: `mvn test`
- [ ] Code compiles: `mvn clean install`
- [ ] PostgreSQL running and configured
- [ ] Database created: `vibe_code_db`
- [ ] Application starts: `mvn spring-boot:run`
- [ ] API responds: `curl http://localhost:8080/teachers`
- [ ] No debug code left
- [ ] Documentation updated

## 📊 HTTP Status Codes

| Code | Meaning |
|------|---------|
| 200 | ✅ Success (GET/PUT) |
| 201 | ✅ Created (POST) |
| 204 | ✅ No Content (DELETE) |
| 400 | ❌ Bad Request |
| 404 | ❌ Not Found |
| 500 | ❌ Server Error |

## 🎓 Learning Resources

- [Spring Boot Docs](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [PostgreSQL Docs](https://www.postgresql.org/docs/)
- [REST API Design](https://restfulapi.net/)
- [Git Documentation](https://git-scm.com/doc)
- [GitHub Copilot Guide](https://github.com/features/copilot)

---

**Last Updated**: July 22, 2026
**Version**: 2.0
**Print this for your desk! 📋**











