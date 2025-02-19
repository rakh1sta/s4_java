package edu.epam.fop.web.jpa.repository;

import edu.epam.fop.web.jpa.entity.Grade;
import edu.epam.fop.web.jpa.entity.GradeId;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class GradeRepository implements JpaRepository<Grade, GradeId> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public Class<Grade> getEntityClass() {
        return Grade.class;
    }

    @Override
    public GradeId getId(Grade grade) {
        return grade.getId();
    }
}
