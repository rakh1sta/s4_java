package edu.epam.fop.web.demos.task1;

import edu.epam.fop.web.jpa.repository.CourseRepository;

import java.util.Scanner;

public class ActivateCourseDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CourseRepository courseRepository = new CourseRepository();

        System.out.println("\nActive Courses:");
        courseRepository.getActiveCourses().forEach(System.out::println);

        scanner.close();
    }
}
