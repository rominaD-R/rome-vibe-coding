package com.example.vibe_code.controller;

import com.example.vibe_code.model.Teacher;
import com.example.vibe_code.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teachers")
@CrossOrigin(origins = "*")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    // GET all teachers
    @GetMapping
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        List<Teacher> teachers = teacherService.getAllTeachers();
        return ResponseEntity.ok(teachers);
    }

    // GET a specific teacher by ID
    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable Long id) {
        Optional<Teacher> teacher = teacherService.getTeacherById(id);
        return teacher.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // POST - Create a new teacher
    @PostMapping
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
        Teacher createdTeacher = teacherService.createTeacher(teacher);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTeacher);
    }

    // PUT - Update an existing teacher
    @PutMapping("/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher) {
        Optional<Teacher> updatedTeacher = teacherService.updateTeacher(id, teacher);
        return updatedTeacher.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // DELETE - Remove a teacher
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable Long id) {
        if (teacherService.deleteTeacher(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}

