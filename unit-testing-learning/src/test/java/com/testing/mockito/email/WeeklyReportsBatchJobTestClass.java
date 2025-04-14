package com.testing.mockito.email;

import com.testing.mockito.mocks.email.EmailSender;
import com.testing.mockito.mocks.email.WeeklyReportsBatchJob;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class WeeklyReportsBatchJobTestClass {

    @Mock
    private EmailSender emailSenderMock;

    private AutoCloseable closeable;

    @BeforeEach
    public void setupMock() {

        closeable = openMocks(this);
    }

    @AfterEach
    public void releaseMocks() throws Exception {

        closeable.close();
    }

    @Test
    public void testGenerateWeeklyReportSingleRecipient() {

        var batchJob = new WeeklyReportsBatchJob(emailSenderMock);

        when(emailSenderMock.sendEmail("alex.neacsa@email.com",
                "Test message")).thenReturn(true);

        assertFalse(batchJob.generateWeeklyReport("Sales", "edi.neacsa@email.com"));
    }
}
