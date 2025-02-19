package edu.epam.fop.web.jpa.repository;

import edu.epam.fop.web.jpa.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class StudentRepository implements JpaRepository<Student, Long> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }

    @Override
    public Long getId(Student student) {
        return student.getId();
    }
}
