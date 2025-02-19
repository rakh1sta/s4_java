package edu.epam.fop.web.jpa.repository;

import edu.epam.fop.web.jpa.entity.DisciplineCourse;
import edu.epam.fop.web.jpa.entity.DisciplineCourseId;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class DisciplineCourseRepository implements JpaRepository<DisciplineCourse, DisciplineCourseId> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public Class<DisciplineCourse> getEntityClass() {
        return DisciplineCourse.class;
    }

    @Override
    public DisciplineCourseId getId(DisciplineCourse disciplineCourse) {
        return disciplineCourse.getId();
    }
}
