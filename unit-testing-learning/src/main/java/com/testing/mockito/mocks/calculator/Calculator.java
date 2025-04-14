package com.testing.mockito.mocks.calculator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Calculator {

    private final Logger logger;

    public int add(int a, int b) {
        logger.log("Adding " + a + " + " + b);
        return a + b;
    }

    public int subtract(int a, int b) {
        logger.log("Subtracting " + a + " - " + b);
        return a - b;
    }

    public int multiply(int a, int b) {
        logger.log("Multiplying " + a + " * " + b);
        return a * b;
    }

    public int divide(int a, int b) {
        logger.log("Dividing " + a + " / " + b);
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero!");
        }
        return a / b;
    }

    public int calculateSomething() {
        int result1 = add(5, 3);
        int result2 = subtract(result1, 2);
        return multiply(result2, 10);
    }

    public void skipCalculation() {
        System.out.println("No calculation needed");
    }
}
