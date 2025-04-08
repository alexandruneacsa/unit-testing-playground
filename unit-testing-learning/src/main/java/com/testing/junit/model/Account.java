package com.testing.junit.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Account {

    private String name;
    private Double accountNumber;
    private Integer customerId;
    private Double balance;
    private String accountType;

    public void deposit(double depositAmount){
        balance = balance + depositAmount;
    }

    public boolean withdraw(double withdrawAmount){
        if(withdrawAmount > balance){
            System.out.println("Insufficient Funds");
            return false;
        } else {
            balance = balance - withdrawAmount;
            return true;
        }
    }
}
