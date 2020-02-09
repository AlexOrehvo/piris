package com.piris.bank.resource.rest;

import com.piris.bank.domain.ActivePassiveAccount;
import com.piris.bank.domain.BankAccount;
import com.piris.bank.domain.Deposit;
import com.piris.bank.domain.DevelopmentFund;
import com.piris.bank.services.DepositService;
import com.piris.bank.util.BankAccountCreator;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank")
public class BankResource {

    private DepositService depositService;

    public BankResource(DepositService depositService) {
        this.depositService = depositService;
    }

    @GetMapping("/deposits")
    public List<Deposit> getDeposits() {
        return depositService.getDeposits();
    }

    @PostMapping("/deposits")
    public BankAccount saveDeposit(@RequestBody BankAccount bankAccount) {
        depositService.createDepositForClient(bankAccount);
        return null;
    }

    @GetMapping("/customer-accounts")
    public List<ActivePassiveAccount> getCustomerAccounts() {
        return depositService.getCustomerAccounts();
    }

    @GetMapping("/development-funds")
    public List<DevelopmentFund> getDevelopmentFunds() {
        return BankAccountCreator.getBankFund();
    }

    @PostMapping("/revoke-account")
    public String revokeCustomerAccount(@RequestBody ActivePassiveAccount customerAccount) {
        depositService.revokeCustomerAccount(customerAccount);
        return "Success";
    }

    @PostMapping("close-day")
    public void closeDay() {
        depositService.closeDay();
    }
}
