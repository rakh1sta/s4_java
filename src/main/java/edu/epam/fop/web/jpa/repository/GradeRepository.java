package edu.epam.fop.web.jpa.repository;

import edu.epam.fop.web.jpa.entity.Grade;
import edu.epam.fop.web.jpa.entity.GradeId;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

public class GradeRepository implements JpaRepository<Grade, GradeId> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        return emf.createEntityManager();
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
