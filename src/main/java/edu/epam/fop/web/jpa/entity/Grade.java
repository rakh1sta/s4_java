package edu.epam.fop.web.jpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

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


   }

