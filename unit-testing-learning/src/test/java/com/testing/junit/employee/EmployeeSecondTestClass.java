package com.testing.junit.employee;

import com.testing.junit.model.Employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeSecondTestClass {

    static Employee firstEmployee;
    static Employee secondEmployee;

    @BeforeAll
    static void initialzeEmployee() {

        firstEmployee = new Employee(
                "Andrei", "Ionescu", 201, 'M', 8200.0, "QA Engineer",
                "Full-Time", List.of("Telco")
        );

        secondEmployee = new Employee(
                "Ioana", "Dumitrescu", 202, 'F', 6800.0, "QA Engineer",
                "Part-Time", List.of("Telco")
        );
    }

    @Test
    void assertRoleTest() {

        assertTrue(firstEmployee.getRole().equals(secondEmployee.getRole()));
    }

    @Test
    void assertSalaryTest() {

        assertFalse(firstEmployee.getSalary().equals(secondEmployee.getSalary()));
    }

    @Test
    void assertSameTest() {

        var shadowFirstEmployee = firstEmployee;
        assertSame(firstEmployee, shadowFirstEmployee);
    }

    @Test
    void assertNotSameTest() {

        var shadowFirstEmployee = firstEmployee;
        assertNotSame(secondEmployee, shadowFirstEmployee);
    }

    @Test
    void assertAllTest() {

        assertAll("Employee test",
                () -> assertNotNull(firstEmployee),
                () -> assertTrue(firstEmployee.getFirstName().equals("Andrei")));
    }
}
