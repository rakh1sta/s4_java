package edu.epam.fop.web.demos.task1;

import edu.epam.fop.web.jpa.entity.Student;
import edu.epam.fop.web.jpa.repository.StudentRepository;

public class CreateStudentDemo {

    public static void main(String[] args) {
        String name = args[0];
        StudentRepository studentRepository = new StudentRepository();

        studentRepository.save(new Student(name));
    }
}
