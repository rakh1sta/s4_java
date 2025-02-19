package edu.epam.fop.web.jpa.repository;

import edu.epam.fop.web.jpa.entity.Discipline;
import edu.epam.fop.web.jpa.entity.Grade;
import edu.epam.fop.web.jpa.entity.GradeId;
import edu.epam.fop.web.jpa.entity.Student;
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

    public void addOrUpdateGrade(Long studentId, Long disciplineId, Integer gradeValue) {
        Student student = entityManager.find(Student.class, studentId);
        Discipline discipline = entityManager.find(Discipline.class, disciplineId);

        if (student != null && discipline != null) {
            GradeId gradeId = new GradeId(studentId, disciplineId);
            Grade grade = entityManager.find(Grade.class, gradeId);

            if (grade == null) {
                grade = new Grade();
                grade.setId(gradeId);
                grade.setStudent(student);
                grade.setDiscipline(discipline);
                student.getGrades().add(grade);
            }

            grade.setValue(gradeValue);
            entityManager.persist(grade);
        }
    }

    public void deleteGrade(Long studentId, Long disciplineId) {
        GradeId gradeId = new GradeId(studentId, disciplineId);
        Grade grade = entityManager.find(Grade.class, gradeId);

        if (grade != null) {
            Student student = grade.getStudent();
            student.getGrades().remove(grade);
            entityManager.remove(grade);
        }
    }
}
