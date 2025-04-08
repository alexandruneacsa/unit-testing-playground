package com.testing.junit.employee;

import com.testing.junit.model.Employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class EmoloyeeFirstTestClass {

    static Employee employee;

    @BeforeAll
    static void initEmployee() {

        employee = new Employee("Ana", "Popescu",
                101, 'F', 7500.0,
                "Software Developer", "Full-Time", List.of("Telco"));
    }

    @Test
    void assertAdjustSalaryTest() {

        employee.adjustSalary(5000);
        assertEquals(12500, employee.getSalary());
        assertNotEquals(7500, employee.getSalary());
    }
}
