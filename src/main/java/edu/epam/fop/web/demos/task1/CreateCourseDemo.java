package edu.epam.fop.web.demos.task1;

import edu.epam.fop.web.jpa.entity.Course;
import edu.epam.fop.web.jpa.repository.CourseRepository;

public class CreateCourseDemo {

    public static void main(String[] args) {
        String name = args[0];
        CourseRepository courseRepository = new CourseRepository();

        courseRepository.save(new Course(name));
    }
}
