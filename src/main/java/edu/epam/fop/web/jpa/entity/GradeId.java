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
public class GradeId implements Serializable {

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "discipline_id")
    private Long disciplineId;

    public GradeId() {}

    public GradeId(Long studentId, Long disciplineId) {
        this.studentId = studentId;
        this.disciplineId = disciplineId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GradeId gradeId = (GradeId) o;
        return Objects.equals(studentId, gradeId.studentId) &&
                Objects.equals(disciplineId, gradeId.disciplineId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, disciplineId);
    }

    @Override
    public String toString() {
        return "GradeId{" +
                "studentId=" + studentId +
                ", disciplineId=" + disciplineId +
                '}';
    }
}

