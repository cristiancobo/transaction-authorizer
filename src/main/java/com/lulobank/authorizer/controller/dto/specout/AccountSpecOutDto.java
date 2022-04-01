package com.lulobank.authorizer.controller.dto.specout;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents an account special entry  dto
 */
public class AccountSpecOutDto {

    private boolean activeCard;

    private int availableLimit;

    private List<String> violations;

    public AccountSpecOutDto() {
        this.violations = new ArrayList<>();
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

    public void addViolation(String violation){

        violations.add(violation);
    }
}
