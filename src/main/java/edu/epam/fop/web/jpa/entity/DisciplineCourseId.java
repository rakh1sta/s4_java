package edu.epam.fop.web.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class DisciplineCourseId implements Serializable {

    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "discipline_id")
    private Long disciplineId;

    // Constructors, getters, setters, equals, and hashCode

    public DisciplineCourseId() {}

    public DisciplineCourseId(Long courseId, Long disciplineId) {
        this.courseId = courseId;
        this.disciplineId = disciplineId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(Long disciplineId) {
        this.disciplineId = disciplineId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisciplineCourseId that = (DisciplineCourseId) o;
        return Objects.equals(courseId, that.courseId) &&
                Objects.equals(disciplineId, that.disciplineId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, disciplineId);
    }
}

