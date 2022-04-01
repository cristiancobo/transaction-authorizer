package com.lulobank.authorizer.controller.dto.stdout;

import com.lulobank.authorizer.entity.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AccountStdOutDto {

    private int id;

    private boolean activeCard;

    private int availableLimit;

    private List<String> violations;

    private List<Transaction> transactionsAccount;

    public AccountStdOutDto() {
        this.violations = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActiveCard() {
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

    public void setViolations(List<String> violations) {
        this.violations = violations;
    }

    public void addTransaction(Transaction transaction){
        if(transactionsAccount == null){
            transactionsAccount=new ArrayList<>();
        }
        transactionsAccount.add(transaction);
    }

    public List<Transaction> getTransactionsAccount() {
        return transactionsAccount;
    }

    public void addViolation(String violation){

        violations.add(violation);
    }

    public void setTransactionsAccount(List<Transaction> transactions) {
        this.transactionsAccount = transactions;
    }
}
