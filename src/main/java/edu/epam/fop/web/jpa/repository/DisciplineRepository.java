package edu.epam.fop.web.jpa.repository;

import edu.epam.fop.web.jpa.entity.Discipline;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

public class DisciplineRepository implements JpaRepository<Discipline, Long> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        return emf.createEntityManager();
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
