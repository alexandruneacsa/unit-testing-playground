package com.testing.junit.account;

import com.testing.junit.model.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountFirstTestClass {

    Account account = new Account("Alex",
            11401533.0, 114532,
            5000.0, "Savings");

    @Test
    public void validateName() {

        assertNotNull(account.getName());
        assertEquals("Alex", account.getName());
    }

    @Test
    public void validateBalance() {

        assertTrue(account.getBalance() >= 0);
    }
}
