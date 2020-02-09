package com.piris.bank.domain;

import com.piris.bank.common.enums.*;
import com.piris.bank.domain.common.UUIDEntity;

import javax.persistence.*;

@Entity
@Table(name = "deposits")
public class Deposit extends UUIDEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double percent;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DepositType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CurrencyType currency;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    public DepositType getType() {
        return type;
    }

    public void setType(DepositType type) {
        this.type = type;
    }

    public CurrencyType getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyType currency) {
        this.currency = currency;
    }
}
