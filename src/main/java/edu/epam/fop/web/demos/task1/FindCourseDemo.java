package edu.epam.fop.web.demos.task1;

import edu.epam.fop.web.jpa.repository.CourseRepository;
import edu.epam.fop.web.jpa.repository.StudentRepository;

public class FindCourseDemo {

    public static void main(String[] args) {
        CourseRepository courseRepository = new CourseRepository();

        Long id = Long.valueOf(args[0]);
        System.out.println(courseRepository.find(id));
    }
}
