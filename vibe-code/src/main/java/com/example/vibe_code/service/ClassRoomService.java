package com.example.vibe_code.service;

import com.example.vibe_code.model.ClassRoom;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClassRoomService {
    private List<ClassRoom> classes = new ArrayList<>();
    private int nextId = 1;

    public ClassRoomService() {
        // Initialize with sample data
        classes.add(new ClassRoom(nextId++, "Java 101", "John Doe", 25, "MWF 9:00-10:00"));
        classes.add(new ClassRoom(nextId++, "Python Basics", "Jane Smith", 30, "TTh 10:00-11:30"));
        classes.add(new ClassRoom(nextId++, "Web Development", "Bob Johnson", 20, "MWF 2:00-3:30"));
    }

    // Get all classes
    public List<ClassRoom> getAllClasses() {
        return new ArrayList<>(classes);
    }

    // Get a class by ID
    public Optional<ClassRoom> getClassById(int id) {
        return classes.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
    }

    // Add a new class
    public ClassRoom addClass(ClassRoom classRoom) {
        classRoom.setId(nextId++);
        classes.add(classRoom);
        return classRoom;
    }

    // Update a class
    public Optional<ClassRoom> updateClass(int id, ClassRoom updatedClass) {
        Optional<ClassRoom> existing = getClassById(id);
        if (existing.isPresent()) {
            ClassRoom classRoom = existing.get();
            classRoom.setName(updatedClass.getName());
            classRoom.setInstructor(updatedClass.getInstructor());
            classRoom.setStudentCount(updatedClass.getStudentCount());
            classRoom.setSchedule(updatedClass.getSchedule());
            return Optional.of(classRoom);
        }
        return Optional.empty();
    }

    // Delete a class
    public boolean deleteClass(int id) {
        return classes.removeIf(c -> c.getId() == id);
    }

    // Get classes by instructor
    public List<ClassRoom> getClassesByInstructor(String instructor) {
        return classes.stream()
                .filter(c -> c.getInstructor().equalsIgnoreCase(instructor))
                .toList();
    }

    // Get total number of students across all classes
    public int getTotalStudents() {
        return classes.stream()
                .mapToInt(ClassRoom::getStudentCount)
                .sum();
    }
}

