package com.piris.bank.domain;

import com.piris.bank.common.enums.CurrencyType;

import java.math.BigDecimal;

public class DevelopmentFund {

    private BigDecimal accountAmount;

    private String name;

    private CurrencyType currency;

    public DevelopmentFund(BigDecimal accountAmount, String name, CurrencyType currency) {
        this.accountAmount = accountAmount;
        this.name = name;
        this.currency = currency;
    }

    public BigDecimal getAccountAmount() {
        return accountAmount;
    }

    public void setAccountAmount(BigDecimal accountAmount) {
        this.accountAmount = accountAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CurrencyType getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyType currency) {
        this.currency = currency;
    }
}
