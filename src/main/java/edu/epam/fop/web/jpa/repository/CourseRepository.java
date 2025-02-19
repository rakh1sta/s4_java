package edu.epam.fop.web.jpa.repository;

import edu.epam.fop.web.jpa.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class CourseRepository implements JpaRepository<Course, Long> {
    // TODO write your code here
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public Class<Course> getEntityClass() {
        return Course.class;
    }

    @Override
    public Long getId(Course entity) {
        return entity.getId();
    }
}
