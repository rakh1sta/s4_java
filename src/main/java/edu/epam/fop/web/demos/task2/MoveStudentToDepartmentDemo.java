package edu.epam.fop.web.demos.task2;

import edu.epam.fop.web.jpa.entity.Department;
import edu.epam.fop.web.jpa.entity.Student;
import edu.epam.fop.web.jpa.repository.DepartmentRepository;
import edu.epam.fop.web.jpa.repository.StudentRepository;

public class MoveStudentToDepartmentDemo {

    public static void main(String[] args) {
        Long studentId = Long.valueOf(args[0]);
        Long departmentId = Long.valueOf(args[1]);

        StudentRepository studentRepository = new StudentRepository();
        DepartmentRepository departmentRepository = new DepartmentRepository();

        Student student = studentRepository.find(studentId);
        Department department = departmentRepository.find(departmentId);
        if (student == null || department == null) {
            throw new IllegalArgumentException("Invalid student or department ID.");
        }

        studentRepository.moveStudentToDepartment(student, department);
        System.out.println("Student successfully moved to the new department.");
    }
}
