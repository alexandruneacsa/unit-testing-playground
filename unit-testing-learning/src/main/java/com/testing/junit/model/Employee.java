package com.testing.junit.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Employee {

    private String firstName;
    private String lastName;
    private Integer id;
    private Character gender;
    private Double salary;
    private String role;
    private String type;
    private List<String> projects;

    public void adjustSalary(double adjAmount) {

        if ((salary + adjAmount) > 90000) {

            System.out.println("The salary esceeds the limit");
            return;
        }

        System.out.println("Updating salary from" + salary + " to" + (salary + adjAmount));
        salary = salary + adjAmount;
    }

    public void increaseSalary(double adjAmount) {
        if (adjAmount > 5000) {

            System.out.println("The increment exceeds the limit. Applying a 5k increase...");
            adjAmount = 5000;
        }

        System.out.println("Updating salary from" + salary + " to" + (salary + adjAmount));
        salary = salary + adjAmount;
    }

    public void validateLastName() {

        if (!this.lastName.matches("^[a-zA-Z]*$")) {

            throw new RuntimeException("The last name should contain only alphabets");
        }
    }

    public void validateFirstName() {

        if (!this.lastName.matches("^[a-zA-Z]*$")) {

            throw new RuntimeException("The last name should contain only alphabets");
        }
    }

    public void addProject(String projectName) {
        projects.add(projectName);
    }
}
