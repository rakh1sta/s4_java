package edu.epam.fop.web.jpa.repository;

import edu.epam.fop.web.jpa.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class CourseRepository implements JpaRepository<Course, Long> {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Course> getActiveCourses() {
        return entityManager.createQuery("SELECT e FROM " + getEntityClass().getSimpleName() + " e WHERE e.active", getEntityClass())
                .getResultList();
    }

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
