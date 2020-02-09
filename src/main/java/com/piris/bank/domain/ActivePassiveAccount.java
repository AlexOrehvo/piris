package com.piris.bank.domain;

public class ActivePassiveAccount {

    private BankAccount active;

    private BankAccount passive;

    public BankAccount getActive() {
        return active;
    }

    public void setActive(BankAccount active) {
        this.active = active;
    }

    public BankAccount getPassive() {
        return passive;
    }

    public void setPassive(BankAccount passive) {
        this.passive = passive;
    }
}
