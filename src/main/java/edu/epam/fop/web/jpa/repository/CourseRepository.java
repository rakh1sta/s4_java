package edu.epam.fop.web.jpa.repository;

import edu.epam.fop.web.jpa.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class CourseRepository implements JpaRepository<Course, Long> {
    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        return emf.createEntityManager();
    }
    public boolean deactivateCourse(Long id) {
        Course entity = find(id);
        if (entity != null) {
            entity.setActive(false);
            getEntityManager().merge(entity);
            return true;
        }
        return false;
    }

    @Override
    public Class<Course> getEntityClass() {
        return Course.class;
    }

    @Override
    public Long getId(Course entity) {
        return entity.getId();
    }

    public List<Course> findAllActive() {
        return getEntityManager().createQuery("SELECT e FROM Course e WHERE e.active", getEntityClass())
                .getResultList();
    }

    public List<Course> printFutureCourses() {
        return getEntityManager().createQuery("SELECT c FROM Course c WHERE c.startAt > :today", getEntityClass())
                .setParameter("today", LocalDate.now())
                .getResultList();
    }

    public Course updateCourseStartDate(Long courseId, LocalDateTime newStartDate) {
        Course course = find(courseId);
        if (course == null)
            throw new IllegalArgumentException("Course with ID " + courseId + " not found.");
        course.setStartAt(newStartDate);
        getEntityManager().merge(course);
        return find(courseId);
    }

    public Course updateCourseEndDate(Long courseId, LocalDateTime newEndDate) {
        Course course = find(courseId);
        if (course == null)
            throw new IllegalArgumentException("Course with ID " + courseId + " not found.");
        course.setEndAt(newEndDate);
        getEntityManager().merge(course);

        return find(courseId);
    }
}
