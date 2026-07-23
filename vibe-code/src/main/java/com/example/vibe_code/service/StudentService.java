package com.example.vibe_code.service;

import com.example.vibe_code.model.Student;
import com.example.vibe_code.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get student by ID
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    // Create a new student
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    // Update an existing student
    public Optional<Student> updateStudent(Long id, Student studentDetails) {
        Optional<Student> existing = studentRepository.findById(id);
        if (existing.isPresent()) {
            Student student = existing.get();
            if (studentDetails.getFirstName() != null) {
                student.setFirstName(studentDetails.getFirstName());
            }
            if (studentDetails.getLastName() != null) {
                student.setLastName(studentDetails.getLastName());
            }
            if (studentDetails.getEmail() != null) {
                student.setEmail(studentDetails.getEmail());
            }
            if (studentDetails.getEnrollmentDate() != null) {
                student.setEnrollmentDate(studentDetails.getEnrollmentDate());
            }
            if (studentDetails.getGradeLevel() != null) {
                student.setGradeLevel(studentDetails.getGradeLevel());
            }
            if (studentDetails.getPhoneNumber() != null) {
                student.setPhoneNumber(studentDetails.getPhoneNumber());
            }
            return Optional.of(studentRepository.save(student));
        }
        return Optional.empty();
    }

    // Delete a student
    public boolean deleteStudent(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Get student by email
    public Optional<Student> getStudentByEmail(String email) {
        return studentRepository.findByEmail(email);
    }
}

