package edu.epam.fop.web.demos.task4;

import edu.epam.fop.web.jpa.repository.DisciplineRepository;

public class LinkCourseDisciplineDemo {

    public static void main(String[] args) {
        // TODO write your code here
        if (args.length != 2) {
            System.out.println("Usage: LinkCourseDisciplineDemo <course_id> <discipline_id>");
            return;
        }

        Long courseId = Long.parseLong(args[0]);
        Long disciplineId = Long.parseLong(args[1]);
        DisciplineRepository repository = new DisciplineRepository();

        repository.linkCourseDiscipline(courseId, disciplineId);
        System.out.println("Course and discipline linked");
    }
}
