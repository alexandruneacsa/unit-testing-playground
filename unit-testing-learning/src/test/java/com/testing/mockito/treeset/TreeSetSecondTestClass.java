package com.testing.mockito.treeset;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Comparator;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class TreeSetSecondTestClass {

    @Mock
    private Comparator<String> comparatorMock;

    private AutoCloseable closeable;

    @BeforeEach
    public void initMocks() {

        closeable = openMocks(this);

        when(comparatorMock.compare("Alexandru", "Valentin")).thenReturn(1);
        when(comparatorMock.compare("Valentin", "Alexandru")).thenReturn(-1);
    }

    @AfterEach
    public void releaseMock() throws Exception {

        closeable.close();
    }

    @Test
    public void treeSetTest() {

        TreeSet<String> treeSet = new TreeSet<>(comparatorMock);

        treeSet.add("Alexandru");
        treeSet.add("Valentin");

        assertEquals("Valentin", treeSet.first());
        assertEquals("Alexandru", treeSet.last());
    }
}
