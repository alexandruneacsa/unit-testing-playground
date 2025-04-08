package com.testing.junit.employee;

import com.testing.junit.model.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EmployeeSixthTestClass {

    static Stream<String> getFirstName() {

        return Stream.of("Alexandru", "Valentin", "Eduard");
    }

    @ParameterizedTest
    @DisplayName("First name check")
    @MethodSource("getFirstName")
    void firstNameCheckTest(String firstName) {

        var employee = new Employee(firstName, "Popescu",
                1001, 'M', 1000.0,
                "Software Developer", "Full-Time", List.of("Telco"));

        assertNotNull(employee.getFirstName());
    }

    @ParameterizedTest(name = "Test #{index} - First name: {0}")
    @DisplayName("Name check")
    @MethodSource("getFirstName")
    void nameCheckTest(String firstName) {

        var employee = new Employee(firstName, "Popescu",
                1001, 'M', 1000.0,
                "Software Developer", "Full-Time", List.of("Telco"));

        assertNotNull(employee.getFirstName());
    }
}
