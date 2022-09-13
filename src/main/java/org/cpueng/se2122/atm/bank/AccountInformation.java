package org.cpueng.se2122.atm.bank;

public interface AccountInformation {
    String getAccountNumber();
    String getFirstName();
    String getLastName();
    String getAddress();
    String getEmail();
    Long getPhone();
    double getCurrentBalance();
    double getCreditBalance();
}
