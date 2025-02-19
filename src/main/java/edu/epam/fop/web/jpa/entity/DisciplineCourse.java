package edu.epam.fop.web.jpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "discipline_course")
public class DisciplineCourse {

    @EmbeddedId
    private DisciplineCourseId id;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @MapsId("disciplineId")
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "grading")
    private Grading grading = Grading.NONE;

    // Getters and setters
    public DisciplineCourseId getId() {
        return id;
    }

    public void setId(DisciplineCourseId id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public Grading getGrading() {
        return grading;
    }

    public void setGrading(Grading grading) {
        this.grading = grading;
    }
}

