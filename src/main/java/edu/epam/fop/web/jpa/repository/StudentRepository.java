package edu.epam.fop.web.jpa.repository;

import edu.epam.fop.web.jpa.entity.Department;
import edu.epam.fop.web.jpa.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

public class StudentRepository implements JpaRepository<Student, Long> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }

    @Override
    public Long getId(Student student) {
        return student.getId();
    }

    public boolean activateStudent(Long id) {
        Student entity = find(id);
        if (entity == null) {
            throw new RuntimeException("User not found");
        }
        entity.setActive(true);
        entityManager.merge(entity);
        return true;
    }

    @Transactional
    public void moveStudentToDepartment(Student student, Department department) {
        student.setDepartment(department);
        entityManager.merge(student);
    }

    public List<Student> findAllByDepartment(Long departmentId) {
        return entityManager.createQuery("SELECT s FROM Student s WHERE s.department.id = :deptId", Student.class)
                .setParameter("deptId", departmentId)
                .getResultList();
    }

}
