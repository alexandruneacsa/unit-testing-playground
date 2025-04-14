package com.testing.mockito.comparator;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ComparatorMockTestClass {

    @Test
    public void mockComparator() {

        //Mocking
        Comparator<String> comparatorMock = mock(Comparator.class);

        //Stubbing
        when(comparatorMock.compare("Alexandru", "Valentin")).thenReturn(1);
        when(comparatorMock.compare("Valentin", "Alexandru")).thenReturn(-1);

        //Asserting
        assertTrue(comparatorMock.compare("Alexandru", "Valentin") > 0);
        assertTrue(comparatorMock.compare("Valentin", "Alexandru") < 0);
    }
}
