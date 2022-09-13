package org.cpueng.se2122.atm.app;

import org.cpueng.se2122.atm.bank.BankApi;

public interface ATMService {

    /* 
     * This is a dependency.
     * sets the ID reader that's used to get additional information about the account owner.
     * 
     */
    void setIDReader(IDReader idReader);

    /*
     * This is a dependency.
     * sets the Bank API that's used to connect to a bank.
     */
    void setBankApi(BankApi bankApi);

    /* 
     *
     * Widthraw money (no return).
     * 
     */
    void withdraw(double amount, int pin);

    /* 
     *
     * Deposit money (no return)
     * 
     */
    void deposit(double amount, int pin);

    /* 
     *
     * Inquire about account information (return account information).  Only display appropriate 
     * information for ATM.  ATM machines don't display personal information and only the last 4 
     * characters of the account number string is displayed prefixed with a "****".
     * 
     */
    ATMDisplayable accountInquiry(int pin);

    /* 
     *
     * Transfer money between two bank accounts (no return)
     * 
     */
    void transfer(String destinationAccountNumber, double amount, int pin);
}
