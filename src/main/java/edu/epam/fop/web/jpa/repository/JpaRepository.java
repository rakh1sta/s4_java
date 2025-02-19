package edu.epam.fop.web.jpa.repository;

import jakarta.persistence.EntityManager;

/**
 * @param <Entity> - type of JPA entity
 * @param <Id>     - type of primary key
 */
public interface JpaRepository<Entity, Id> {

    default Id save(Entity entity) {
        EntityManager entityManager = getEntityManager();
        entityManager.persist(entity);
        return getId(entity);
    }

    default Entity find(Id id) {
        EntityManager entityManager = getEntityManager();
        return entityManager.find(getEntityClass(), id);
    }

    default Entity update(Id id, Entity newValues) {
        EntityManager entityManager = getEntityManager();
        Entity existingEntity = entityManager.find(getEntityClass(), id);
        if (existingEntity != null) {
            entityManager.merge(newValues);
        }
        return existingEntity;
    }

    default void delete(Id id) {
        EntityManager entityManager = getEntityManager();
        Entity entity = entityManager.find(getEntityClass(), id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    EntityManager getEntityManager();

    Class<Entity> getEntityClass();

    Id getId(Entity entity);
}
