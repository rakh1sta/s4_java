package edu.epam.fop.web.jpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "grade")
public class Grade {

    @EmbeddedId
    private GradeId id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @MapsId("disciplineId")
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;

    @Min(0)
    @Max(100)
    @Column(name = "value")
    private Integer value;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Grade grade = (Grade) object;
        return Objects.equals(id, grade.id) && Objects.equals(student, grade.student) && Objects.equals(discipline, grade.discipline) && Objects.equals(value, grade.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, student, discipline, value);
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", student=" + student +
                ", discipline=" + discipline +
                ", value=" + value +
                '}';
    }
}

