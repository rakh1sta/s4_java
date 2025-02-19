package edu.epam.fop.web.demos.task1;

import edu.epam.fop.web.jpa.repository.CourseRepository;

public class DeleteCourseDemo {

    public static void main(String[] args) {
        CourseRepository courseRepository = new CourseRepository();

        Long id = Long.valueOf(args[0]);
        courseRepository.delete(id);
    }
}
