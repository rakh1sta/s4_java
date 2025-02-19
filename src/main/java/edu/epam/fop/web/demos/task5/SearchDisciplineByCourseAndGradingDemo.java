package edu.epam.fop.web.demos.task5;

import edu.epam.fop.web.jpa.entity.Discipline;
import edu.epam.fop.web.jpa.entity.Grading;
import edu.epam.fop.web.jpa.repository.DisciplineRepository;

import java.util.List;

public class SearchDisciplineByCourseAndGradingDemo {

    public static void main(String[] args) {
        // TODO write your code here
        if (args.length != 2) {
            System.out.println("Usage: SearchDisciplineByCourseAndGradingDemo <course_id> <grading>");
            return;
        }

        Long courseId = Long.parseLong(args[0]);
        Grading grading = Grading.valueOf(args[1].toUpperCase());

        DisciplineRepository repository = new DisciplineRepository();
        List<Discipline> disciplines = repository.findDisciplinesByCourseAndGrading(courseId, grading);

        System.out.println("Disciplines for course " + courseId + " with grading " + grading + ":");
        for (Discipline discipline : disciplines) {
            System.out.println("Discipline : " + discipline);
        }
    }
}
