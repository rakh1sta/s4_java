package edu.epam.fop.web.jpa.repository;

import edu.epam.fop.web.jpa.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

import java.util.List;

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

    public void linkCourseDiscipline(Long courseId, Long disciplineId) {
        Discipline discipline = entityManager.find(Discipline.class, disciplineId);
        Course course = entityManager.find(Course.class, courseId);
        if (course != null && discipline != null) {
            course.getDisciplines().add(discipline);
            discipline.getCourses().add(course);
        } else {
            throw new IllegalArgumentException("Course or Discipline not found");
        }
    }

    @Override
    public void delete(Long aLong) {
        Discipline discipline = entityManager.find(Discipline.class, aLong);
        if (discipline != null) {
            for (Course course : discipline.getCourses()) {
                course.getDisciplines().remove(discipline);
            }
            entityManager.remove(discipline);
        }
    }

    public List<Course> findCoursesOfDiscipline(Long disciplineId) {
        return entityManager.createQuery("SELECT c FROM Course c JOIN c.disciplines d WHERE d.id = :disciplineId", Course.class)
                .setParameter("disciplineId", disciplineId)
                .getResultList();
    }

    public List<Discipline> findDisciplinesForCourse(Long courseId) {
        return entityManager.createQuery("SELECT d FROM Discipline d JOIN d.courses c WHERE c.id = :courseId", Discipline.class)
                .setParameter("courseId", courseId)
                .getResultList();
    }

    public void unlinkCourseDiscipline(Long courseId, Long disciplineId) {
        Course course = entityManager.find(Course.class, courseId);
        Discipline discipline = entityManager.find(Discipline.class, disciplineId);
        if (course != null && discipline != null) {
            course.getDisciplines().remove(discipline);
            discipline.getCourses().remove(course);
        }
    }

    public List<Discipline> findDisciplinesByCourseAndGrading(Long courseId, Grading grading) {
        return entityManager.createQuery(
                        "SELECT dc.discipline FROM DisciplineCourse dc " +
                                "WHERE dc.course.id = :courseId AND dc.grading = :grading", Discipline.class)
                .setParameter("courseId", courseId)
                .setParameter("grading", grading)
                .getResultList();
    }

    public void updateGradingType(Long courseId, Long disciplineId, Grading grading) {
        DisciplineCourseId id = new DisciplineCourseId(courseId, disciplineId);
        DisciplineCourse disciplineCourse = entityManager.find(DisciplineCourse.class, id);
        if (disciplineCourse != null) {
            disciplineCourse.setGrading(grading);
        }
    }
}
