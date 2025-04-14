package com.testing.mockito.calculator;

import com.testing.mockito.mocks.calculator.Calculator;
import com.testing.mockito.mocks.calculator.Logger;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CalculatorServiceTest {

    @Mock
    private Logger logger;

    @InjectMocks
    private Calculator calculator;

    @Test
    void testAddition() {

        var result = calculator.add(2, 3);

        assertEquals(5, result);

        verify(logger).log("Adding 2 + 3");
    }

    @Test
    void testSubtract() {

        var result = calculator.subtract(10, 3);

        assertEquals(7, result);

        verify(logger).log("Subtracting 10 - 3");
    }

    @Test
    @Disabled()
    void testMultiplyNoLoggerInteraction() {

        var result = calculator.multiply(3, 4);

        verifyNoInteractions(logger);

        assertEquals(12, result);
    }

    @Test
    void testDivide() {

        var result = calculator.divide(10, 2);

        assertEquals(5, result);

        verify(logger).log("Dividing 10 / 2");
    }

    @Test
    void testDivideByZero() {

        var exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        });

        assertEquals("Cannot divide by zero!", exception.getMessage());

        verify(logger).log("Dividing 10 / 0");
    }

    @Test
    @Disabled()
    void testNoInteractionWithLoggerWhenNotUsed() {

        var result = calculator.add(1, 2);

        verifyNoInteractions(logger);

        assertEquals(3, result);
    }

    @Test
    void testMultipleMethodCalls() {

        calculator.add(1, 2);
        calculator.subtract(5, 3);

        verify(logger).log("Adding 1 + 2");
        verify(logger).log("Subtracting 5 - 3");

        verifyNoMoreInteractions(logger);
    }

    @Test
    void testVerifyNoMoreInteractionsAfterTests() {

        calculator.multiply(3, 4);
        calculator.divide(10, 2);

        verify(logger).log("Multiplying 3 * 4");
        verify(logger).log("Dividing 10 / 2");

        verifyNoMoreInteractions(logger);
    }

    @Test
    void testNoInteraction() {

        var mockCalc = mock(Calculator.class);
        mockCalc.skipCalculation();

        verify(mockCalc).skipCalculation();
        verify(mockCalc, never()).add(anyInt(), anyInt());
        verify(mockCalc, never()).multiply(anyInt(), anyInt());
    }

    @Test
    void testAddWithArgumentCaptor() {

        Logger loggerMock = mock(Logger.class);
        Calculator calculator = new Calculator(loggerMock);

        calculator.add(5, 7);

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(loggerMock).log(captor.capture());

        String actualLog = captor.getValue();
        assertEquals("Adding 5 + 7", actualLog);
    }
}

