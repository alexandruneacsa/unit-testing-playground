package com.testing.mockito.mocks.email;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
public class WeeklyReportsBatchJob {

    private EmailSender emailSender;

    public boolean generateWeeklyReport(String reportType, String emailRecipient) {

        return emailSender.sendEmail(emailRecipient,
                String.format("The %s weekly report has been generated", reportType));
    }
}
