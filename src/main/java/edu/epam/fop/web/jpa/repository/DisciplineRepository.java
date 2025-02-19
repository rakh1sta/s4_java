package edu.epam.fop.web.jpa.repository;

import edu.epam.fop.web.jpa.entity.Discipline;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class DisciplineRepository implements JpaRepository<Discipline, Long> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public Class<Discipline> getEntityClass() {
        return Discipline.class;
    }

    @Override
    public Long getId(Discipline discipline) {
        return discipline.getId();
    }
}
