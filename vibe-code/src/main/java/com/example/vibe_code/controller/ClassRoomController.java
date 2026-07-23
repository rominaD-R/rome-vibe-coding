package com.example.vibe_code.controller;

import com.example.vibe_code.model.ClassRoom;
import com.example.vibe_code.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/classes")
@CrossOrigin(origins = "*")
public class ClassRoomController {

    @Autowired
    private ClassRoomService classRoomService;

    // GET all classes
    @GetMapping
    public ResponseEntity<List<ClassRoom>> getAllClasses() {
        List<ClassRoom> classes = classRoomService.getAllClasses();
        return ResponseEntity.ok(classes);
    }

    // GET a specific class by ID
    @GetMapping("/{id}")
    public ResponseEntity<ClassRoom> getClassById(@PathVariable int id) {
        Optional<ClassRoom> classRoom = classRoomService.getClassById(id);
        return classRoom.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // POST - Create a new class
    @PostMapping
    public ResponseEntity<ClassRoom> createClass(@RequestBody ClassRoom classRoom) {
        ClassRoom createdClass = classRoomService.addClass(classRoom);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdClass);
    }

    // PUT - Update an existing class
    @PutMapping("/{id}")
    public ResponseEntity<ClassRoom> updateClass(@PathVariable int id, @RequestBody ClassRoom classRoom) {
        Optional<ClassRoom> updatedClass = classRoomService.updateClass(id, classRoom);
        return updatedClass.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // DELETE - Remove a class
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClass(@PathVariable int id) {
        if (classRoomService.deleteClass(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // GET classes by instructor name
    @GetMapping("/instructor/{instructorName}")
    public ResponseEntity<List<ClassRoom>> getClassesByInstructor(@PathVariable String instructorName) {
        List<ClassRoom> classes = classRoomService.getClassesByInstructor(instructorName);
        return ResponseEntity.ok(classes);
    }

    // GET total number of students
    @GetMapping("/stats/total-students")
    public ResponseEntity<Integer> getTotalStudents() {
        int total = classRoomService.getTotalStudents();
        return ResponseEntity.ok(total);
    }

    // GET health check endpoint
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Class Manager API is running!");
    }
}

