package com.example.vibe_code.service;

import com.example.vibe_code.model.Teacher;
import com.example.vibe_code.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    // Get all teachers
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    // Get teacher by ID
    public Optional<Teacher> getTeacherById(Long id) {
        return teacherRepository.findById(id);
    }

    // Create a new teacher
    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    // Update an existing teacher
    public Optional<Teacher> updateTeacher(Long id, Teacher teacherDetails) {
        Optional<Teacher> existing = teacherRepository.findById(id);
        if (existing.isPresent()) {
            Teacher teacher = existing.get();
            if (teacherDetails.getFirstName() != null) {
                teacher.setFirstName(teacherDetails.getFirstName());
            }
            if (teacherDetails.getLastName() != null) {
                teacher.setLastName(teacherDetails.getLastName());
            }
            if (teacherDetails.getEmail() != null) {
                teacher.setEmail(teacherDetails.getEmail());
            }
            if (teacherDetails.getSubject() != null) {
                teacher.setSubject(teacherDetails.getSubject());
            }
            if (teacherDetails.getDepartment() != null) {
                teacher.setDepartment(teacherDetails.getDepartment());
            }
            return Optional.of(teacherRepository.save(teacher));
        }
        return Optional.empty();
    }

    // Delete a teacher
    public boolean deleteTeacher(Long id) {
        if (teacherRepository.existsById(id)) {
            teacherRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Get teacher by email
    public Optional<Teacher> getTeacherByEmail(String email) {
        return teacherRepository.findByEmail(email);
    }
}

