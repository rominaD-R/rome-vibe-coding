# Team Startup Checklist 📋

Complete this checklist before your first development session. Each team member should complete steps 1-5.

---

## 🔧 Environment Setup (Everyone)

### Step 1: Install Required Software
- [ ] Java 11 or higher installed
  ```bash
  java -version
  ```
- [ ] Maven 3.6+ installed
  ```bash
  mvn -version
  ```
- [ ] Git installed
  ```bash
  git --version
  ```
- [ ] PostgreSQL installed
  ```bash
  postgres --version
  ```
- [ ] Text editor or IDE (JetBrains IntelliJ, VS Code, etc.)

### Step 2: Clone Repository
```bash
[ ] Clone the project
git clone <repository-url>
cd vibe-code

[ ] Verify project structure
ls -la src/main/java/com/example/vibe_code/
```

### Step 3: Configure MySQL
```bash
[ ] Start MySQL
brew services start mysql

[ ] Create database
mysql -u root -p
CREATE DATABASE vibe_code_db;
EXIT;

[ ] Verify database created
mysql -u root -p -e "SHOW DATABASES;" | grep vibe_code_db
```

### Step 4: Build Project
```bash
[ ] Clean build
mvn clean install

[ ] Verify build successful (should end with "BUILD SUCCESS")
```

### Step 5: Run Application
```bash
[ ] Start application
mvn spring-boot:run

[ ] Verify startup (should see console messages about running on port 8080)

[ ] Test API in another terminal
curl http://localhost:8080/teachers
# Should return JSON array (possibly empty)
```

---

## 👥 Team Organization (Lead Developer)

### Step 6: Set Up GitHub Repository (Repo Owner)
- [ ] Create repository on GitHub
- [ ] Add team members as collaborators
- [ ] Set up branch protection rules for main branch
- [ ] Create GitHub issues for tasks
- [ ] Set up project board (optional)

### Step 7: Distribute Tasks
- [ ] Divide work among team members
  - Teacher CRUD enhancements
  - Student CRUD enhancements
  - Testing (unit/integration)
  - Documentation
  - Database optimization
- [ ] Create feature branches for each task
- [ ] Assign issues to team members

---

## 📝 Development Workflow (All Team Members)

### For Each Feature
1. [ ] Create feature branch
   ```bash
   git checkout -b feature/your-feature-name
   ```

2. [ ] Make changes
   - Edit code following the layered architecture
   - Create test cases
   - Update documentation

3. [ ] Test locally
   ```bash
   mvn test
   mvn spring-boot:run
   ```

4. [ ] Commit changes
   ```bash
   git add .
   git commit -m "Add: clear description"
   ```

5. [ ] Push branch
   ```bash
   git push origin feature/your-feature-name
   ```

6. [ ] Create Pull Request on GitHub
   - Add description
   - Link related issues
   - Request code review

7. [ ] Code Review
   - Wait for team review
   - Address feedback
   - Push updates

8. [ ] Merge to Main
   - Once approved, merge PR
   - Delete feature branch
   - Pull latest main locally

---

## 🧪 Pre-Deployment Verification (Lead Developer)

Before submitting the project:

### Code Quality
- [ ] All tests pass: `mvn test`
- [ ] No warnings in compiler output
- [ ] Code follows project structure
- [ ] No debug code left in repository

### Documentation
- [ ] README.md is complete and accurate
- [ ] API_DOCUMENTATION.md has all endpoints
- [ ] Code comments are clear where needed
- [ ] TESTING_GUIDE.md examples work

### Database
- [ ] Schema is correct (run migrations if needed)
- [ ] Sample data exists or can be created
- [ ] Database constraints are in place
- [ ] Unique constraints (emails) are working

### API Testing
- [ ] GET /teachers returns all teachers
- [ ] POST /teachers creates new teacher
- [ ] PUT /teachers/{id} updates teacher
- [ ] DELETE /teachers/{id} deletes teacher
- [ ] GET /students returns all students
- [ ] POST /students creates new student
- [ ] PUT /students/{id} updates student
- [ ] DELETE /students/{id} deletes student
- [ ] All 404 error cases handled
- [ ] All 201 Created responses return correct status

### Git Repository
- [ ] All code is committed
- [ ] No uncommitted changes
- [ ] Main branch is clean
- [ ] Feature branches are deleted
- [ ] No sensitive data in commits

### Final Review
- [ ] Team lead reviews all code
- [ ] Code standards are met
- [ ] Documentation is complete
- [ ] Project is ready for submission

---

## 📊 Project Checklist Summary

### Core Implementation
- [x] Teacher model with JPA annotations
- [x] Student model with JPA annotations
- [x] TeacherRepository with Spring Data JPA
- [x] StudentRepository with Spring Data JPA
- [x] TeacherService with CRUD logic
- [x] StudentService with CRUD logic
- [x] TeacherController with REST endpoints
- [x] StudentController with REST endpoints
- [x] PostgreSQL configuration in application.properties
- [x] Automatic schema creation

### API Endpoints (10 Required)
- [x] GET /teachers
- [x] GET /teachers/{id}
- [x] POST /teachers
- [x] PUT /teachers/{id}
- [x] DELETE /teachers/{id}
- [x] GET /students
- [x] GET /students/{id}
- [x] POST /students
- [x] PUT /students/{id}
- [x] DELETE /students/{id}

### Documentation
- [x] README.md
- [x] API_DOCUMENTATION.md
- [x] GIT_COLLABORATION_GUIDE.md
- [x] TESTING_GUIDE.md
- [x] QUICK_REFERENCE.md
- [x] IMPLEMENTATION_SUMMARY.md

### Testing
- [x] Unit test examples
- [x] Integration test examples
- [x] curl command examples
- [x] API test documentation

### Git/GitHub
- [x] Project ready for GitHub
- [x] .gitignore configured
- [x] Clean commit history ready
- [x] Collaboration guidelines documented

---

## 🚀 Common Issues and Solutions

| Issue | Solution |
|-------|----------|
| PostgreSQL won't start | `brew services restart postgresql` |
| Cannot connect to database | Verify PostgreSQL is running and database exists |
| Maven build fails | Try `mvn clean install -DskipTests` |
| Port 8080 already in use | Change port in `application.properties` or stop other app |
| Tests fail locally but pass in CI | Clear `target/` folder: `mvn clean` |
| Git merge conflicts | Edit files, resolve conflicts, `git add .`, `git commit` |
| API returns 404 | Verify endpoint URL matches controller mapping |

---

## 📞 Quick Links

- **API Base URL**: `http://localhost:8080`
- **Teachers Endpoint**: `http://localhost:8080/teachers`
- **Students Endpoint**: `http://localhost:8080/students`
- **API Docs**: See `API_DOCUMENTATION.md`
- **Git Guide**: See `GIT_COLLABORATION_GUIDE.md`
- **Testing**: See `TESTING_GUIDE.md`

---

## ✅ First Day Milestone

At the end of the first day:
- [ ] Everyone has project running locally
- [ ] Database is set up
- [ ] At least one team member has made a test commit
- [ ] Team understands the project structure
- [ ] Team has divided responsibilities
- [ ] Feature branches are created and work begins

---

## 📋 Team Information

**Project Name**: Teacher and Student Management System
**Repository**: [Add your GitHub URL]
**Project Lead**: [Add name]
**Team Members**:
- [ ] Member 1: 
- [ ] Member 2: 
- [ ] Member 3: 
- [ ] Member 4: 

**Status**: Ready for Development ✅

---

**Created**: July 22, 2026
**Last Updated**: July 22, 2026
**Version**: 1.0


