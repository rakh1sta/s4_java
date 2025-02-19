package edu.epam.fop.web.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

    @Override
    public String toString() {
        return "DisciplineCourse{" +
                "id=" + id +
                ", course=" + course +
                ", discipline=" + discipline +
                ", grading=" + grading +
                '}';
    }
}

