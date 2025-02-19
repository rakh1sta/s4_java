package edu.epam.fop.web.demos.task2;

import edu.epam.fop.web.jpa.repository.StudentRepository;

public class SearchStudentsByDepartmentDemo {

    public static void main(String[] args) {
        Long id = Long.valueOf(args[0]);

        StudentRepository studentRepository = new StudentRepository();

        studentRepository.findAllByDepartment(id).forEach(System.out::println);
    }
}
