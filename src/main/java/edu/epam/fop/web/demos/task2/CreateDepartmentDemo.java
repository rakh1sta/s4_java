package edu.epam.fop.web.demos.task2;

import edu.epam.fop.web.jpa.entity.Department;
import edu.epam.fop.web.jpa.repository.DepartmentRepository;

public class CreateDepartmentDemo {

    public static void main(String[] args) {
        String name = args[0];
        DepartmentRepository departmentRepository = new DepartmentRepository();

        departmentRepository.save(new Department(name));
    }
}
