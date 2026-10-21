package com.stemgon.database_demo;

import com.stemgon.database_demo.dao.StudentDAO;
import com.stemgon.database_demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DatabaseDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return  runner -> {
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		// Create student
		System.out.println("Creating new student");
		Student newStudent = new Student("Carrington", "Muleya", "carrie.muleya@gmail.com");

		// Saving the student
		System.out.println("Saving the student");
		studentDAO.save(newStudent);

		// Get the id of the student
		System.out.println("id of the student " + newStudent.getId());
	}
}
