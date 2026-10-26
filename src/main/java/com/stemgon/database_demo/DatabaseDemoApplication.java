package com.stemgon.database_demo;

import com.stemgon.database_demo.dao.StudentDAO;
import com.stemgon.database_demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DatabaseDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return  runner -> {
			// createStudent(studentDAO);
			// readStudent(studentDAO);
			// queryForStudent(studentDAO);
			// queryForStudentsByLastName(studentDAO);
			// mergeStudent(studentDAO);
			deleteStudent(studentDAO);

		};
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void mergeStudent(StudentDAO studentDAO) {
		// retrieve the student based on id: primary key

		int studentId = 2;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(2);

		// change firstName to harry
		System.out.println("Updating the student");
		myStudent.setFirstName("Harry");

		// update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println(myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		// get list of students
		List<Student> students = studentDAO.findStudentByLastName("Muleya");

		// display students
		for(Student student: students){
			System.out.println(student);
		}
	}

	private void queryForStudent(StudentDAO studentDAO) {
		// get list of students
		List<Student> students = studentDAO.findAll();

		// display list of students
		for(Student student: students){
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating the new student object......");
		Student tempStudent = new Student("Harrington", "Muleya", "harrington@gmail.com");

		// save the student
		System.out.println("Saving the student........");
		studentDAO.save(tempStudent);

		// display the id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved the student: Generated id: " + theId);

		// retrieve the student based on the id: primary key
		System.out.println("Retrieving the student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);


		// display the student
		System.out.println("Found the student: " + myStudent);
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
