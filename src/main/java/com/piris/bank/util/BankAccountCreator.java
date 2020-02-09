package com.piris.bank.util;

import com.piris.bank.common.enums.CurrencyType;
import com.piris.bank.domain.DevelopmentFund;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankAccountCreator {

    public static DevelopmentFund usdBankBill = new DevelopmentFund(new BigDecimal(1000000.0), "BILL", CurrencyType.USD);
    public static DevelopmentFund usdCashBox = new DevelopmentFund(new BigDecimal(0.0), "CASH-BOX", CurrencyType.USD);
    public static DevelopmentFund bynBankBill = new DevelopmentFund(new BigDecimal(1000000.0), "BILL", CurrencyType.BYN);
    public static DevelopmentFund bynCashBox = new DevelopmentFund(new BigDecimal(1000000.0), "CASH-BOX", CurrencyType.BYN);

    public static List<DevelopmentFund> getBankFund() {
        List<DevelopmentFund> developmentFunds = new ArrayList<>();
        developmentFunds.add(usdBankBill);
        developmentFunds.add(usdCashBox);
        developmentFunds.add(bynBankBill);
        developmentFunds.add(bynCashBox);
        return developmentFunds;
    }
}
