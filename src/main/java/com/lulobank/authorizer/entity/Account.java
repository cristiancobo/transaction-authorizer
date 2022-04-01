package com.lulobank.authorizer.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents an account
 */
public class Account {
    /**
     * constants
     */
    public static final String ACCOUNT_ALREADY_INITIALIZED = "account-already-initialized";
    public static final String ACCOUNT_NOT_INITIALIZED = "account-not-initialized";
    public static final String CARD_NOT_ACTIVE = "card-not-active";
    public static final String INSUFFICIENT_LIMIT = "insufficient-limit";
    /**
     * Attributes of class
     */
    private int id;
    private boolean activeCard;
    private int availableLimit;
    private List<String> violations;
    private List<Transaction> transactions;

    /**
     * Constructor
     * @param activeCard
     * @param availableLimit
     */
    public Account(boolean activeCard, int availableLimit) {
        this.id = id;
        this.activeCard = activeCard;
        this.availableLimit = availableLimit;
        this.violations = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }
    /**
     * Getter and settter
     */
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public boolean getActiveCard() {
        return activeCard;
    }
    public void setActiveCard(boolean activeCard) {
        this.activeCard = activeCard;
    }
    public int getAvailableLimit() {
        return availableLimit;
    }
    public void setAvailableLimit(int availableLimit) {
        this.availableLimit = availableLimit;
    }
    public List<String> getViolations() {
        return violations;
    }
    public void setViolations(ArrayList<String> violations) {
        this.violations = violations;
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }
    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }
    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }
    public void addViolation(String violation){
        violations.add(violation);
    }
    /**
     * Methods
     */
    /**
     * Method that drecrease available limit of an account
     * @param amount
     */
    public void decreaseAmount(int amount){
        this.availableLimit = this.availableLimit - amount;
    }

    /**
     * Method that verify whether an account have similars transactions in a
     * 2 minutes interval
     * @param localDateTimeLimit1
     * @param localDateTimeLimit2
     * @param amount
     * @param merchant
     * @return
     */
    public boolean haveSimilarTransactions( LocalDateTime localDateTimeLimit1, LocalDateTime localDateTimeLimit2, int amount, String merchant){
        LocalDateTime localDateTimeLimit1Converted =localDateTimeLimit1.plusMinutes(-2);
        boolean haveSimilar = false;
        int i =transactions.size();
        for ( ; i>0 && !haveSimilar ; ){
            if(haveSimilar = transactions.get(i-1).getTime().isAfter(
                    localDateTimeLimit1Converted) &&
                    transactions.get(i-1).getTime().isBefore(localDateTimeLimit2)
                    && transactions.get(i-1).getAmount()==amount && transactions.get(i-1).getMerchant().equalsIgnoreCase(merchant)){
                haveSimilar = true;
            }
            i--;
        }
        return haveSimilar;
    }

}
