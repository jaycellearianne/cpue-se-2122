package org.cpueng.se2122.atm.bank;

public interface InquiryRequest {
    String getAccountNumber();
    String getFirstName();
    String getLastName();
    int getPin();
}
