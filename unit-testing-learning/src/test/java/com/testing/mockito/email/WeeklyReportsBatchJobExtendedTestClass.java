package com.testing.mockito.email;

import com.testing.mockito.mocks.email.EmailSender;
import com.testing.mockito.mocks.email.WeeklyReportsBatchJob;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WeeklyReportsBatchJobExtendedTestClass {

    @Mock
    private EmailSender emailSenderMock;

    @Test
    public void testGenerateWeeklyReportSingleRecipient() {

        var batchJob = new WeeklyReportsBatchJob(emailSenderMock);

        when(emailSenderMock.sendEmail(
                "edi.neacsa@email.com",
                "The Sales weekly report has been generated"))
                .thenReturn(true);

        assertTrue(batchJob.generateWeeklyReport("Sales", "edi.neacsa@email.com"));
    }
}
