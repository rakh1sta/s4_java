package edu.epam.fop.web.demos.task4;

import edu.epam.fop.web.jpa.entity.Course;
import edu.epam.fop.web.jpa.repository.DisciplineRepository;

import java.util.List;

public class SearchCoursesOfDisciplineDemo {

    public static void main(String[] args) {
        // TODO write your code here
        if (args.length != 1) {
            System.out.println("Usage: SearchCoursesOfDisciplineDemo <discipline_id>");
            return;
        }

        Long disciplineId = Long.parseLong(args[0]);
        DisciplineRepository repository = new DisciplineRepository();

        List<Course> courses = repository.findCoursesOfDiscipline(disciplineId);
        System.out.println("Courses of discipline " + disciplineId + ":");
        for (Course course : courses) {
            System.out.println("Course: " + course.getName());
        }
    }
}
