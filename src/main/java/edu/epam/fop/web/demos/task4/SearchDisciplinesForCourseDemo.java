package edu.epam.fop.web.demos.task4;

import edu.epam.fop.web.jpa.entity.Discipline;
import edu.epam.fop.web.jpa.repository.DisciplineRepository;

import java.util.List;

public class SearchDisciplinesForCourseDemo {

    public static void main(String[] args) {
        // TODO write your code here
        if (args.length != 1) {
            System.out.println("Usage: SearchDisciplinesForCourseDemo <course_id>");
            return;
        }

        Long courseId = Long.parseLong(args[0]);
        DisciplineRepository repository = new DisciplineRepository();

        List<Discipline> disciplines = repository.findDisciplinesForCourse(courseId);
        System.out.println("Disciplines for course " + courseId + ":");
        for (Discipline discipline : disciplines) {
            System.out.println("Distipline: " + discipline);
        }
    }
}
