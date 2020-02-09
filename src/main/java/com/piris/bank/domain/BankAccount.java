package com.piris.bank.domain;

import com.piris.bank.domain.common.UUIDEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "bank_accounts")
public class BankAccount extends UUIDEntity {

    @Column(nullable = false, unique = true)
    private String accountNumber;

    @Column
    private BigDecimal accountAmount;

    @OneToOne
    @JoinColumn(name = "deposit_id")
    private Deposit deposit;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    public BankAccount() {
    }

    public BankAccount(String accountNumber, BigDecimal accountAmount, Deposit deposit, User creator, Date startDate, Date endDate) {
        this.accountNumber = accountNumber;
        this.accountAmount = accountAmount;
        this.deposit = deposit;
        this.creator = creator;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getAccountAmount() {
        return accountAmount;
    }

    public void setAccountAmount(BigDecimal accountAmount) {
        this.accountAmount = accountAmount;
    }

    public Deposit getDeposit() {
        return deposit;
    }

    public void setDeposit(Deposit deposit) {
        this.deposit = deposit;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
