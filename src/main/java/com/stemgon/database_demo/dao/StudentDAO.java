package com.stemgon.database_demo.dao;

import com.stemgon.database_demo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findStudentByLastName(String theLastName);
}
