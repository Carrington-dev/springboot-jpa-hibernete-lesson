package com.stemgon.database_demo.dao;

import com.stemgon.database_demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImple implements StudentDAO{
    // define field for EntityManager;
    private EntityManager entityManager;

    // inject entitymanager using a costructor
    @Autowired
    public StudentDAOImple(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    // implement the save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // create query
        TypedQuery<Student> studentTypedQuery = entityManager.createQuery("FROM Student order by firstName desc", Student.class);

        // return query results
        return studentTypedQuery.getResultList();
    }

    @Override
    public List<Student> findStudentByLastName(String theLastName) {
        // create query
        TypedQuery<Student> studentTypedQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);

        // set query parameters
        studentTypedQuery.setParameter("theData", theLastName);

        // return query set
        return studentTypedQuery.getResultList();
    }
}
