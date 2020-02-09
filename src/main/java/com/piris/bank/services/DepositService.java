package com.piris.bank.services;

import com.piris.bank.domain.ActivePassiveAccount;
import com.piris.bank.domain.BankAccount;
import com.piris.bank.domain.Deposit;

import java.util.List;

public interface DepositService {

    List<Deposit> getDeposits();

    BankAccount createDepositForClient(BankAccount bankAccount);

    List<ActivePassiveAccount> getCustomerAccounts();

    void revokeCustomerAccount(ActivePassiveAccount customerAccount);

    void closeDay();
}
