package edu.epam.fop.web.demos.task4;

import edu.epam.fop.web.jpa.entity.Discipline;
import edu.epam.fop.web.jpa.repository.DisciplineRepository;

public class CreateDisciplineDemo {

    public static void main(String[] args) {
        // TODO write your code here
        if (args.length != 1) {
            System.out.println("Usage: CreateDisciplineDemo <discipline_name>");
            return;
        }

        String disciplineName = args[0];
        DisciplineRepository repository = new DisciplineRepository();

        Discipline discipline = new Discipline();
        discipline.setName(disciplineName);

        Long id = repository.save(discipline);
        System.out.println("Created discipline with ID: " + id);
    }
}
