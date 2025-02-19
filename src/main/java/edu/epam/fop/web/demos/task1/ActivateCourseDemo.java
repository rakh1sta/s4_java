package edu.epam.fop.web.demos.task1;

import edu.epam.fop.web.jpa.repository.CourseRepository;

public class ActivateCourseDemo {

    public static void main(String[] args) {

        CourseRepository courseRepository = new CourseRepository();

//        Long id = Long.valueOf(args[0]);

        Long id = 1L;
        System.out.print(courseRepository.deactivateCourse(id));
    }
}
