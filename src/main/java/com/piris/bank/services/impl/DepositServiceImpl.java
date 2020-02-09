package com.piris.bank.services.impl;

import com.piris.bank.common.enums.DepositType;
import com.piris.bank.domain.ActivePassiveAccount;
import com.piris.bank.domain.BankAccount;
import com.piris.bank.domain.Deposit;
import com.piris.bank.repository.BankAccountRepository;
import com.piris.bank.repository.DepositRepository;
import com.piris.bank.services.DepositService;
import com.piris.bank.util.BankAccountCreator;
import com.piris.bank.util.BankAccountUtil;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class DepositServiceImpl implements DepositService {

    private DepositRepository depositRepository;
    private BankAccountRepository bankAccountRepository;


    public DepositServiceImpl(DepositRepository depositRepository, BankAccountRepository bankAccountRepository) {
        this.depositRepository = depositRepository;
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public List<Deposit> getDeposits() {
        return depositRepository.findAll();
    }

    @Override
    public BankAccount createDepositForClient(BankAccount bankAccount) {
        String bankAccountNumber;
        if (DepositType.REVOCABLE.equals(bankAccount.getDeposit().getType())) {
            bankAccountNumber = BankAccountUtil.REVOCABLE_BILL_NUMBER +
                    BankAccountUtil.generateBillNumber() + "0";
        } else {
            bankAccountNumber = BankAccountUtil.IRREVOCABLE_BILL_NUMBER +
                    BankAccountUtil.generateBillNumber() + "0";
        }
        bankAccount.setAccountNumber(bankAccountNumber);

        BankAccount activeBankAccount =
                new BankAccount(bankAccountNumber.substring(0, bankAccountNumber.length()-1) + "1",
                        new BigDecimal("0"),
                        bankAccount.getDeposit(),
                        bankAccount.getCreator(),
                        bankAccount.getStartDate(),
                        bankAccount.getEndDate());

        bankAccountRepository.save(bankAccount);
        bankAccountRepository.save(activeBankAccount);
        return null;
    }

    @Override
    public List<ActivePassiveAccount> getCustomerAccounts() {
        List<ActivePassiveAccount> customerAccounts = new ArrayList<>();
        List<BankAccount> bankAccounts = bankAccountRepository.findAll();

        for (BankAccount bankAccount : bankAccounts) {
            ActivePassiveAccount customerAccount = new ActivePassiveAccount();
            if (isActiveAccount(bankAccount.getAccountNumber())) {
                String startNumber = bankAccount.getAccountNumber()
                        .substring(0, bankAccount.getAccountNumber().length() - 1);

                BankAccount passiveAccount = null;
                for (BankAccount oneOfAccount: bankAccounts) {
                    if (isRelatedPassiveAccount(oneOfAccount, startNumber)) {
                        passiveAccount = oneOfAccount;
                        break;
                    }
                }

                customerAccount.setActive(bankAccount);
                customerAccount.setPassive(passiveAccount);
                customerAccounts.add(customerAccount);
            }
        }
        return customerAccounts;
    }

    @Override
    public void revokeCustomerAccount(ActivePassiveAccount customerAccount) {
        BankAccount activeAccount = customerAccount.getActive();
        BankAccount passiveAccount = customerAccount.getPassive();
        if (customerAccount.getActive() != null) {
            switch (customerAccount.getActive().getDeposit().getCurrency()) {
                case USD: {
                    BankAccountCreator.usdBankBill.setAccountAmount(
                        BankAccountCreator.usdBankBill.getAccountAmount()
                                .subtract(activeAccount.getAccountAmount())
                                .subtract(passiveAccount.getAccountAmount())
                    );
                    break;
                }
                case BYN: {
                    BankAccountCreator.bynBankBill.setAccountAmount(
                            BankAccountCreator.bynBankBill.getAccountAmount()
                                    .subtract(activeAccount.getAccountAmount())
                                    .subtract(passiveAccount.getAccountAmount())
                    );
                    break;
                }
            }

            bankAccountRepository.deleteById(activeAccount.getId());
            bankAccountRepository.deleteById(passiveAccount.getId());
        }
    }

    @Override
    public void closeDay() {
        List<BankAccount> accounts = bankAccountRepository.findAll();
        for (BankAccount account : accounts) {
            if (isActiveAccount(account.getAccountNumber())) {
                String numberPart = account.getAccountNumber().substring(0, account.getAccountNumber().length()-1);
                BankAccount passiveAccount = getPassiveAccountByPartOfAccountNumber(accounts, numberPart);

                if (passiveAccount != null) {
                    Double percent = passiveAccount.getDeposit().getPercent();
                    Double currentAmount = account.getAccountAmount()
                            .add(passiveAccount.getAccountAmount()).doubleValue();

                    Double moneyToAdd = currentAmount * percent / 100.0 / 365.0;

                    account.setAccountAmount(account.getAccountAmount().add(new BigDecimal(moneyToAdd)));

                    bankAccountRepository.save(account);
                }
            }
        }
    }

    private boolean isActiveAccount(String accountNumber) {
        return accountNumber.endsWith("1");
    }

    private BankAccount getPassiveAccountByPartOfAccountNumber(List<BankAccount> accounts, String commonPart) {
        for (BankAccount account : accounts) {
            if (isRelatedPassiveAccount(account, commonPart)) {
                return account;
            }
        }
        return null;
    }

    private boolean isRelatedPassiveAccount(BankAccount account, String commonPart) {
        return account.getAccountNumber().startsWith(commonPart) && account.getAccountNumber().endsWith("0");
    }
}
