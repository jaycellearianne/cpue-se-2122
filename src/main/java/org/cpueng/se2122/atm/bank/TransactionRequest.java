package org.cpueng.se2122.atm.bank;

public interface TransactionRequest {
    String getAccountNumber();
    String getFirstName();
    String getLastName();
    double getTransactionAmount();
    int getPin();
    TransactionType getTransactionType();
}
