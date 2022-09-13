package org.cpueng.se2122.atm.bank;

public interface BankApi {
    /**
     * Execute bank transaction request.  Request can either be a withdrawal or deposit request.
     * 
     * @param request - the request object that contains the request details.
     * 
     * @throws IllegalAccessException - thrown when pin is wrong for the account.
     * @throws IllegalCallerException - thrown when account information 
     *                                  (name, surname, and account number) for 
     *                                  identification is wrong.
     * 
     * @throws IllegalStateException - thrown when account balance is not enough to execute the 
     *                                 transaction.
     */
    void executeTransaction(TransactionRequest request) 
        throws IllegalAccessException, IllegalCallerException, IllegalArgumentException;

    
    /**
     * Returns the account information of the account number specified in the inquiry request.
     * 
     * @param request the object that holds data about the inquiry request.
     * 
     * @return - object that holds account information of the account number being requested
     *           for inquiry 
     * 
     * @throws IllegalAccessException - thrown when pin is wrong for the account.
     * @throws IllegalCallerException - thrown when account information 
     *                                  (name, surname, and account number) for 
     *                                  identification is wrong.
     */
    AccountInformation getAccountInformation(InquiryRequest request) 
        throws IllegalAccessException, IllegalCallerException;

    
    /**
     * Execute bank account transfer request.  Transfers are usually done between two accounts, 
     * so the source account number and the destination account number must be specified correctly.
     * 
     * @param request the object that contains information about the transfer request.
     * 
     * @throws IllegalAccessException - thrown when pin is wrong for the source account.
     * @throws IllegalCallerException - thrown when either source account or destination account 
     *                                  are invalid.
     * 
     * @throws IllegalArgumentException - thrown when source account balance is not enough to 
     *                                    execute the transfer.
     */
    void executeTransferRequest(TransferRequest request) 
        throws IllegalAccessException, IllegalCallerException, IllegalArgumentException;;
}
