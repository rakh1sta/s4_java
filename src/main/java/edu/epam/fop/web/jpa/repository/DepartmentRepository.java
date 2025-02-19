package edu.epam.fop.web.jpa.repository;

import edu.epam.fop.web.jpa.entity.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class DepartmentRepository implements JpaRepository<Department, Long> {
    // TODO write your code here
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public Class<Department> getEntityClass() {
        return Department.class;
    }

    @Override
    public Long getId(Department department) {
        return department.getId();
    }
}
