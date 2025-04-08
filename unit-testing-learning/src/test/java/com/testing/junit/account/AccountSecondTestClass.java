package com.testing.junit.account;

import com.testing.junit.model.Account;
import org.junit.jupiter.api.*;

public class AccountSecondTestClass {

    Account account;

    @BeforeAll
    static void initAll() {
        System.out.println("@BeforeAll block has been executed");
        System.out.println("Initialize all");
    }

    @BeforeEach
    void init() {

         account = new Account("Alex",
                11401533.0, 114532,
                5000.0, "Savings");

        System.out.println("@BeforeEach block has been executed");
        System.out.println("Account balance: " + account.getBalance());
    }

    @Test
    void depositTest() {

        account.deposit(500);
        System.out.println("@Test block for deposit has been executed");
    }

    @Test
    void withdrawTest() {

        account.withdraw(1000);
        System.out.println("@Test block for withdraw has been executed");
    }

    @AfterEach
    void balance() {

        System.out.println("@AfterEach has been executed");
        System.out.println("Account balance: " + account.getBalance());
    }

    @AfterAll
    static void tearDownAll() {

        System.out.println("@AfterAll block has been executed");
        System.out.println("Clean all");
    }
}
