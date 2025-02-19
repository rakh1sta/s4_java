package edu.epam.fop.web.demos.task3;

import edu.epam.fop.web.jpa.repository.CourseRepository;

public class SearchFutureCoursesDemo {

    public static void main(String[] args) {
        CourseRepository courseRepository = new CourseRepository();
        courseRepository.printFutureCourses().forEach(System.out::println);
    }
}
