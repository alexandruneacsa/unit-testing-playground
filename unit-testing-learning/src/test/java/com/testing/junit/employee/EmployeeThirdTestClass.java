package com.testing.junit.employee;

import com.testing.junit.model.Employee;
import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeThirdTestClass {

    static Employee firstEmployee;
    static Employee secondEmployee;
    static Employee thirdEmployee;
    static GregorianCalendar gc;

    @BeforeAll
    static void initEmployee() {

        firstEmployee = new Employee("Ana", "Popescu",
                101, 'F', 7500.0,
                "Software Developer", "Full-Time", List.of("Telco"));

        secondEmployee = null;

        thirdEmployee = new Employee("Ana", "4escu",
                101, 'F', 7500.0,
                "Software Developer", "Full-Time", List.of("Telco"));

        gc = new GregorianCalendar();
    }

    @Test
    void assertTimeoutTest() {

        assertTimeout(Duration.ofSeconds(5), () -> firstEmployee.adjustSalary(2000));
    }

    @Test
    void assertNullTest() {

        assertNull(secondEmployee);
    }

    @Test
    void assertNotNull() {

        Assertions.assertNotNull(firstEmployee);
    }

    @Test
    void assertThrowTest() {

        assertThrows(RuntimeException.class, () -> thirdEmployee.validateLastName());
    }

    @Test
    void assumptionTest() {

        Assumptions.assumingThat(gc.get(Calendar.HOUR_OF_DAY) < 23,
                () -> {firstEmployee.adjustSalary(5000);
        assertEquals(12500, firstEmployee.getSalary());});
    }

    @Test
    @Disabled
    void assumptionTimeTest() {

        System.out.println("Current hour: " + gc.get(Calendar.HOUR_OF_DAY));

        Assumptions.assumeTrue(gc.get(Calendar.HOUR_OF_DAY) < 23);

        firstEmployee.adjustSalary(5000);
        Assertions.assertNotNull(firstEmployee.getSalary());

        System.out.println("The assumption was satisfied and the test was run");
    }
}
