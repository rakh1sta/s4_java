package edu.epam.fop.web.demos.task5;

import edu.epam.fop.web.jpa.entity.Grading;
import edu.epam.fop.web.jpa.repository.DisciplineRepository;

public class UpdatingDisciplineCourseRelationDemo {

    public static void main(String[] args) {
        // TODO write your code here
        if (args.length != 3) {
            System.out.println("Usage: UpdatingDisciplineCourseRelationDemo <course_id> <discipline_id> <grading>");
            return;
        }

        Long courseId = Long.parseLong(args[0]);
        Long disciplineId = Long.parseLong(args[1]);
        Grading grading = Grading.valueOf(args[2].toUpperCase());

        DisciplineRepository repository = new DisciplineRepository();
        repository.updateGradingType(courseId, disciplineId, grading);

        System.out.println("Updated grading type for course-discipline relation");
    }

}
