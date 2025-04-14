package com.testing.mockito.treeset;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TreeSetFirstTestClass {

    private Comparator<String> comparatorMock;

    @BeforeEach
    public void initMocks() {

        comparatorMock = mock(Comparator.class);

        when(comparatorMock.compare("Alexandru", "Valentin")).thenReturn(1);
        when(comparatorMock.compare("Valentin", "Alexandru")).thenReturn(-1);
    }

    @AfterEach
    public void releaseMock() {

        comparatorMock = null;
    }

    @Test
    public void treeSetTest() {

        TreeSet<String> treeSet = new TreeSet<>(comparatorMock);

        treeSet.add("Alexandru");
        treeSet.add("Valentin");

        for (var element : treeSet) {

            System.out.println(element);
        }

        assertEquals("Valentin", treeSet.first());
        assertEquals("Alexandru", treeSet.last());
    }
}
