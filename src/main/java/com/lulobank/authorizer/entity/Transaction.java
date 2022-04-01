package com.lulobank.authorizer.entity;

import java.time.LocalDateTime;

/**
 * Class that represents a transaction
 */
public class Transaction {

    /**
     * Constants
     */
    public static final String HIGH_FREQUENCY_SMALL_INTERVAL = "high-frequency-small-interval";
    public static final String DOUBLED_TRANSACTION = "doubled_transaction";

    /**
     * Attributes
     */
    private int id;
    private int accountId;
    private String merchant;
    private int amount;
    private LocalDateTime time;


    /**
     * Constructor
     * @param id
     * @param accountId
     * @param merchant
     * @param amount
     */
    public Transaction(int id,int accountId, String merchant, int amount) {
        this.id = id;
        this.accountId = accountId;
        this.merchant = merchant;
        this.amount = amount;
        this.time = LocalDateTime.now();

    }

    /**
     *
     * Getter and setter
     */

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getAccountId() {
        return accountId;
    }
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
    public String getMerchant() {
        return merchant;
    }
    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public LocalDateTime getTime() {
        return time;
    }
    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    /**
     * Method that verify whether a transaction should be rejected
     * @param transactionN3
     * @return
     */
    public boolean isRejected(LocalDateTime transactionN3) {
        LocalDateTime localDateTimeTransactionN3=  transactionN3.plusMinutes(2);
        return time.isBefore(localDateTimeTransactionN3) ;
    }

}
