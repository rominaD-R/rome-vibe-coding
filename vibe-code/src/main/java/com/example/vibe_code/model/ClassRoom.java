package com.example.vibe_code.model;

public class ClassRoom {
    private int id;
    private String name;
    private String instructor;
    private int studentCount;
    private String schedule;

    // Constructor
    public ClassRoom() {}

    public ClassRoom(int id, String name, String instructor, int studentCount, String schedule) {
        this.id = id;
        this.name = name;
        this.instructor = instructor;
        this.studentCount = studentCount;
        this.schedule = schedule;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return "ClassRoom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", instructor='" + instructor + '\'' +
                ", studentCount=" + studentCount +
                ", schedule='" + schedule + '\'' +
                '}';
    }
}

