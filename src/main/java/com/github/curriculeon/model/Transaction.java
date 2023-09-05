package com.github.curriculeon.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Transaction {
    Long accountId;
    private double withdrawal;
    private double deposit;

    public Transaction() {
    }

    public Transaction(Long accountId, double withdrawal, double deposit) {
        this.accountId = accountId;
        this.withdrawal = withdrawal;
        this.deposit = deposit;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public double getWithdrawal() {
        return withdrawal;
    }

    public void setWithdrawal(double withdrawal) {
        this.withdrawal = withdrawal;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return "Transaction{" +
                    "accountId=" + accountId +
                    ", withdrawal=" + withdrawal +
                    ", deposit=" + deposit +
                    '}';
        }
    }
}
