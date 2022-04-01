package com.lulobank.authorizer.controller.dto.stdin;

import com.lulobank.authorizer.entity.Transaction;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
/**
 * Class that represents an transaction standard entry  dto
 */
public class TransactionStdInDto {
    private int accountId;
    @NotEmpty(message = "The merchant cannot be empty")
    private String merchant;
    @Min(value = 1, message = "The amount must be greater than zero")
    private int amount;
    private LocalDateTime time;

    /**
     * Getter and setter
     */
    public TransactionStdInDto() {
        this.time = LocalDateTime.now();
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
    public int getAccountId() {
        return accountId;
    }
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}
