package edu.epam.fop.web.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "active")
    private boolean active = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Grade> grades = new ArrayList<>();

    @Transient
    private Double averageGrade;


    private void updateAverageGrade() {
        if (grades.isEmpty()) {
            this.averageGrade = null;
        } else {
            double sum = 0;
            int count = 0;
            for (Grade grade : grades) {
                if (grade.getValue() != null) {
                    sum += grade.getValue();
                    count++;
                }
            }
            this.averageGrade = count > 0 ? sum / count : null;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", active=" + active +
                ", department=" + (department != null ? department.getName() : "null") +
                '}';
    }
}

