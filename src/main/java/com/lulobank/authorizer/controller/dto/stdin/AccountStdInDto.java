package com.lulobank.authorizer.controller.dto.stdin;


import javax.validation.constraints.Min;
import java.util.List;
/**
 * Class that represents an account standard entry  dto
 */
public class AccountStdInDto {

    private int id;
    private boolean activeCard;
    private int availableLimit;
    private List<String> violations;
    private List<Integer> transactionsAccount;

    /**
     * Getter and setter
     */
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
    public List<Integer> getTransactionsAccount() {
        return transactionsAccount;
    }
    public void setTransactionsAccount(List<Integer> transactions) {
        this.transactionsAccount = transactions;
    }
}
