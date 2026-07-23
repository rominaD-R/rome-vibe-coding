# Git & GitHub Collaboration Guide

This guide outlines how your team should collaborate on this Spring Boot project using Git and GitHub.

## 📌 Initial Setup (First Time Only)

### 1. One team member creates the repository
```bash
# Initialize a new Git repository
git init

# Add all files
git add .

# Create initial commit
git commit -m "Initial: Spring Boot class manager application setup"

# Create main branch (if not already created)
git branch -M main

# Add remote repository
git remote add origin https://github.com/your-org/vibe-code.git

# Push to GitHub
git push -u origin main
```

### 2. Other team members clone the repository
```bash
git clone https://github.com/your-org/vibe-code.git
cd vibe-code
```

## 🌿 Feature Branch Workflow

This project uses the **Feature Branch Workflow**. Follow these steps for each feature:

### Step 1: Create a Feature Branch
```bash
# Update main branch to latest
git checkout main
git pull origin main

# Create and switch to a new feature branch
git checkout -b feature/your-feature-name
```

**Naming Conventions:**
- `feature/add-student-endpoint` - New features
- `fix/class-deletion-bug` - Bug fixes
- `refactor/simplify-service-layer` - Code improvements
- `docs/api-documentation` - Documentation
- `test/add-unit-tests` - Testing

### Step 2: Make Changes
```bash
# Check status of your changes
git status

# Stage specific files
git add src/main/java/...
# Or add all changes
git add .

# Commit with descriptive message
git commit -m "Add: New endpoint for class filtering by level"
```

**Commit Message Format:**
```
[Type]: Description

Longer explanation if needed (optional)
```

Types:
- `Add`: New feature or file
- `Fix`: Bug fix
- `Update`: Minor changes
- `Refactor`: Code restructuring
- `Test`: Test additions
- `Docs`: Documentation

### Step 3: Push Your Branch
```bash
# Push your feature branch to GitHub
git push origin feature/your-feature-name
```

### Step 4: Create a Pull Request (PR)
1. Go to GitHub repository
2. Click "Compare & pull request"
3. Fill in the PR details:
   - **Title**: Clear, concise description
   - **Description**: What changes were made and why
   - **Related Issues**: Link any relevant issues

### Step 5: Code Review
- Wait for team members to review your code
- Respond to feedback and make requested changes:
  ```bash
  git add .
  git commit -m "Update: Address code review comments"
  git push origin feature/your-feature-name
  ```

### Step 6: Merge to Main
1. Once approved, click "Merge pull request" on GitHub
2. Delete the feature branch (optional but recommended)
   ```bash
   git branch -d feature/your-feature-name
   git push origin --delete feature/your-feature-name
   ```

## 🔄 Keeping Your Branch Updated

If other team members merge changes to main while you're working:

```bash
# Fetch latest changes from main
git fetch origin main

# Rebase your feature branch on main
git rebase origin/main

# If conflicts occur, resolve them manually, then:
git add .
git rebase --continue

# Force push your updated branch
git push origin feature/your-feature-name --force-with-lease
```

## ⚠️ Handling Merge Conflicts

If merge conflicts occur:

1. **Identify conflicts** - Git will mark conflicting sections
2. **Resolve conflicts** - Edit files manually and decide which changes to keep
3. **Mark as resolved**:
   ```bash
   git add <resolved-file>
   ```
4. **Complete merge**:
   ```bash
   git rebase --continue  # or git merge --continue
   ```

Example conflict:
```
<<<<<<< HEAD
    public String getName() {
        return name;
    }
=======
    public String getFullName() {
        return firstName + " " + lastName;
    }
>>>>>>> feature/refactor-naming
```

Choose the correct version and remove the conflict markers.

## 📋 Common Commands

```bash
# Clone repository
git clone <repository-url>

# Create and switch to branch
git checkout -b feature/name

# View branch status
git status

# Stage changes
git add .
git add <specific-file>

# Commit changes
git commit -m "message"

# Push changes
git push origin feature/name

# Pull latest changes
git pull origin main

# View commit history
git log --oneline

# Undo last commit (before pushing)
git reset --soft HEAD~1

# Discard changes
git checkout -- <file>

# Switch between branches
git checkout main
git checkout feature/name

# Delete a branch
git branch -d feature/name

# Merge a branch
git merge feature/name
```

## 🎯 Best Practices

✅ **DO:**
- Pull before starting work
- Create descriptive commit messages
- Push frequently (daily or more)
- Review others' code
- Test your code before pushing
- Keep commits small and focused
- Communicate with team members

❌ **DON'T:**
- Commit directly to main
- Push without testing
- Make unrelated changes in one commit
- Ignore merge conflicts
- Push sensitive information
- Force push to main
- Commit compiled files or dependencies

## 📅 Suggested Workflow Example

```
Monday:
  - Team meets and assigns features
  - Each member creates feature branch
  
Tuesday-Thursday:
  - Team members work on their features
  - Push commits daily
  - Create pull requests as ready
  
Friday:
  - Code review and merge PRs
  - Test merged main branch
  - Plan for next week
```

## 🚨 Emergency: Reverting Changes

If something breaks in main:

```bash
# See commit history
git log --oneline

# Revert to previous commit
git revert <commit-hash>

# Or reset (use with caution)
git reset --hard <commit-hash>
git push origin main --force-with-lease
```

## 📞 Communication

- Use PR comments for code review
- Use GitHub Issues for bug reports and feature requests
- Use team chat (Slack, Discord, etc.) for immediate communication
- Update PR status regularly

## 🔗 Useful Resources

- [GitHub Guides](https://guides.github.com/)
- [Git Documentation](https://git-scm.com/doc)
- [Atlassian Git Tutorials](https://www.atlassian.com/git/tutorials)
- [GitHub Flow Guide](https://guides.github.com/introduction/flow/)

---

**Remember**: Good collaboration is key to a successful group project. Communicate often and review each other's code!

