package com.example.vibe_code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Spring Boot application for the Teacher and Student Management system.
 *
 * This application provides a REST API for managing teachers and students
 * stored in a PostgreSQL database.
 *
 * Endpoints:
 * Teachers:
 *   - GET /teachers - Get all teachers
 *   - GET /teachers/{id} - Get specific teacher
 *   - POST /teachers - Create new teacher
 *   - PUT /teachers/{id} - Update teacher
 *   - DELETE /teachers/{id} - Delete teacher
 *
 * Students:
 *   - GET /students - Get all students
 *   - GET /students/{id} - Get specific student
 *   - POST /students - Create new student
 *   - PUT /students/{id} - Update student
 *   - DELETE /students/{id} - Delete student
 *
 * @author LaunchCode Group Project
 * @version 2.0
 */
@SpringBootApplication
public class VibeCodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(VibeCodeApplication.class, args);
		System.out.println("========================================");
		System.out.println("Teacher and Student Management API");
		System.out.println("Server running on http://localhost:8080");
		System.out.println("========================================");
		System.out.println("Teachers Endpoint: http://localhost:8080/teachers");
		System.out.println("Students Endpoint: http://localhost:8080/students");
		System.out.println("API Documentation: See API_DOCUMENTATION.md");
		System.out.println("========================================");
	}

}
