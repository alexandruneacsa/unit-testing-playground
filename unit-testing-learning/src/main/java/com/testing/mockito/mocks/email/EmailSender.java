package com.testing.mockito.mocks.email;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmailSender {

    private String username;
    private String password;
    private String server;

    public boolean sendEmail(String emailRecipient, String emailContent) {

        System.out.println("Email with content" + emailContent + "was sent to" + emailRecipient );

        return true;
    }
}
