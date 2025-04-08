package com.testing.junit.employee;

import com.testing.junit.model.Employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeFourthTestClass {

    static Employee employee;
    static double salary;

    @BeforeAll
    static void initEmployee() {

        salary = 45000;

        employee = new Employee("Teodor", "Popescu",
                101, 'M', salary,
                "Software Developer", "Full-Time", List.of("Telco"));
    }

    @RepeatedTest(5)
    @DisplayName("Salary update")
    void salaryUpdateTest() {

        var salaryIncrement = 2000;
        employee.adjustSalary(salaryIncrement);
        salary += salaryIncrement;

        assertEquals(salary, employee.getSalary(), "Test salary updates");
    }
}
