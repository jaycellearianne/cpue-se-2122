package org.cpueng.se2122.atm.bank;

public interface TransferRequest {
    String getSourceAccountNumber();
    String getDestinationAccountNumber();
    double getTransferAmount();
    int getPin();
}
