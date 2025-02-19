package edu.epam.fop.web.demos.task3;

import edu.epam.fop.web.jpa.repository.CourseRepository;

import java.time.LocalDateTime;

public class UpdateCourseEndAtDemo {

    public static void main(String[] args) {
        if (args.length == 2) {
            System.out.println("Usage: java UpdateCourseStartDateDemo <courseId> <newEndDate>");
            return;
        }
        Long courseId = Long.parseLong(args[0]);
        LocalDateTime newStartDate = LocalDateTime.parse(args[1]);

        CourseRepository courseRepository = new CourseRepository();
        System.out.println(courseRepository.updateCourseEndDate(courseId, newStartDate));
    }
}
