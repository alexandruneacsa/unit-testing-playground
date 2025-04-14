package com.testing.mockito.email;

import com.testing.mockito.mocks.email.RemoteMachineProxy;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RemoteMachineProxyTestClass {

    private Iterator<String> iteratorMock;

    @BeforeEach
    public void initMock() {

        iteratorMock = mock(Iterator.class);

        when(iteratorMock.next()).thenReturn("Alexandru Neacsa, alex.neacsa@email.com, 23")
                .thenReturn("Dinu Florin, dinu.florin@email.com, 22")
                .thenReturn("Eduard Neacsa, edi.neacsa@email.com, 19");
    }

    @AfterEach
    public void releaseMock() {

        iteratorMock = null;
    }

    @Test
    public void testRemoteMachineProxyGetNextFile() {

        var proxy = new RemoteMachineProxy("url");

        proxy.setRemoteFileIterator(iteratorMock);

        when(iteratorMock.hasNext()).thenReturn(true);
        assertEquals("alex.neacsa@email.com", proxy.getNextFile());

        when(iteratorMock.hasNext()).thenReturn(true);
        assertEquals("dinu.florin@email.com", proxy.getNextFile());

        when(iteratorMock.hasNext()).thenReturn(true);
        assertEquals("edi.neacsa@email.com", proxy.getNextFile());

        when(iteratorMock.hasNext()).thenReturn(true);
        assertEquals("edi.neacsa@email.com", proxy.getNextFile());

        when(iteratorMock.hasNext()).thenReturn(false);
        assertNull(proxy.getNextFile());
    }
}
