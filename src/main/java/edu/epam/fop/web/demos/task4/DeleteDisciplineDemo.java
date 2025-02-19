package edu.epam.fop.web.demos.task4;

import edu.epam.fop.web.jpa.repository.DisciplineRepository;

public class DeleteDisciplineDemo {

    public static void main(String[] args) {
        // TODO write your code here
        if (args.length != 1) {
            System.out.println("Usage: DeleteDisciplineDemo <discipline_id>");
            return;
        }

        Long disciplineId = Long.parseLong(args[0]);
        DisciplineRepository repository = new DisciplineRepository();

        repository.delete(disciplineId);
        System.out.println("Discipline deleted ");
    }
}
