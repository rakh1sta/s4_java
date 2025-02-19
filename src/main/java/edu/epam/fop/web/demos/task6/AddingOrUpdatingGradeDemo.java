package edu.epam.fop.web.demos.task6;

import edu.epam.fop.web.jpa.repository.GradeRepository;

public class AddingOrUpdatingGradeDemo {

    public static void main(String[] args) {
        // TODO write your code here
        if (args.length != 3) {
            System.out.println("Usage: AddingOrUpdatingGradeDemo <student_id> <discipline_id> <grade_value>");
            return;
        }

        Long studentId = Long.parseLong(args[0]);
        Long disciplineId = Long.parseLong(args[1]);
        Integer gradeValue = Integer.parseInt(args[2]);

        GradeRepository repository = new GradeRepository();
        repository.addOrUpdateGrade(studentId, disciplineId, gradeValue);

        System.out.println("Grade added or updated successfully");
    }

}
