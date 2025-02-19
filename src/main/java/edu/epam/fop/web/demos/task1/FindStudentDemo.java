package edu.epam.fop.web.demos.task1;

import edu.epam.fop.web.jpa.repository.StudentRepository;

public class FindStudentDemo {

    public static void main(String[] args) {
        StudentRepository studentRepository = new StudentRepository();

        Long id = Long.valueOf(args[0]);
        System.out.println(studentRepository.find(id));
    }
}
