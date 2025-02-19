package edu.epam.fop.web.jpa.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
        updateAverageGrade();
    }

    public Double getAverageGrade() {
        return averageGrade;
    }

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

