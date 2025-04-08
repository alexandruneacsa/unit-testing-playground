package com.testing.junit.employee;

import com.testing.junit.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeFifthTestClass {

    static Employee firstEmployee;
    static double salary;

    @BeforeAll
    static void initEmployee() {

        salary = 45000;

        firstEmployee = new Employee("Teodor", "Popescu",
                101, 'M', salary,
                "Software Developer", "Full-Time", List.of("Telco"));
    }

    @ParameterizedTest
    @DisplayName("Salary increase")
    @ValueSource(doubles = {500, 1000, 1500, 2000, 2500})
    void salaryIncreaseTest(double salaryIncrement) {

        firstEmployee.adjustSalary(salaryIncrement);
        salary += salaryIncrement;

        assertEquals(salary, firstEmployee.getSalary(), "Test salary increase");
    }

    @ParameterizedTest
    @DisplayName("First name check")
    @ValueSource(strings = {"Alex", "Ion", "Andrei"})
    void firstNameCheckTest(String firstName) {

        var secondEmployee = new Employee(firstName, "Popescu",
                102, 'M', salary,
                "Software Developer", "Full-Time", List.of("Telco"));

      assertNotNull(secondEmployee.getFirstName());
    }

    @ParameterizedTest
    @DisplayName("Null name check")
    @NullSource
    void nullNameCheckTest(String firstName) {

        var thirdEmployee = new Employee(firstName, "Popescu",
                103, 'M', salary,
                "Software Developer", "Full-Time", List.of("Telco"));

        assertNull(thirdEmployee.getFirstName());
    }

    @ParameterizedTest
    @DisplayName("Empty name check")
    @EmptySource
    void emptyNameCheckTest(String firstName) {

        var fourthEmployee = new Employee(firstName, "Popescu",
                104, 'M', salary,
                "Software Developer", "Full-Time", List.of("Telco"));

        assertEquals("", fourthEmployee.getFirstName());
    }

    @ParameterizedTest
    @DisplayName("Empty or null name check")
    @NullAndEmptySource
    void emptyAndNullNameCheckTest(String firstName) {

        var fifthEmployee = new Employee(firstName, "Popescu",
                105, 'M', salary,
                "Software Developer", "Full-Time", List.of("Telco"));

        assertTrue(fifthEmployee.getFirstName() == null || fifthEmployee.getFirstName() == "");
    }

    @ParameterizedTest
    @DisplayName("Csv name check")
    @CsvFileSource(resources = "/employee-names.csv", numLinesToSkip = 1)
    void csvNameCheckTest(String firstName, String lastName) {

        var sixthEmployee = new Employee(firstName.trim(), lastName.trim(),
                106, 'M', salary,
                "Software Developer", "Full-Time", List.of("Telco"));

        assertEquals(firstName.trim(), sixthEmployee.getFirstName());
        assertEquals(lastName.trim(), sixthEmployee.getLastName());
    }
}
