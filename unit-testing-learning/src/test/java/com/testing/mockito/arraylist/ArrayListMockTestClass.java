package com.testing.mockito.arraylist;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ArrayListMockTestClass {

    @Test
    public void mockfirstArrayList(){

        //Mocking
        var someArrayList = mock(ArrayList.class);

        //Stubbing
        when(someArrayList.isEmpty()).thenReturn(true);
        when(someArrayList.size()).thenReturn(10);
        when(someArrayList.toArray()).thenReturn(new Object[]{2, 4, 8});

        //Asserting
        assertTrue(someArrayList.isEmpty());
        assertEquals(10, someArrayList.size());
        assertArrayEquals(new Object[]{2, 4, 8}, someArrayList.toArray());
    }

    @Test
    public void mockSecondArrayList(){

        //Mocking
        var someArrayList = mock(ArrayList.class);

        //Stubbing
        when(someArrayList.contains("Alexandru")).thenReturn(true);
        when(someArrayList.contains("Valentin")).thenReturn(false);

        //Asserting
        assertTrue(someArrayList.contains("Alexandru"));
        assertFalse(someArrayList.contains("Valentin"));
    }
}
