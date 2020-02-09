package com.piris.bank.util;

import java.util.Random;

public class BankAccountUtil {

    public static final String REVOCABLE_BILL_NUMBER = "3404";
    public static final String IRREVOCABLE_BILL_NUMBER = "3414";
    public static final String MONTHLY_BILL_NUMBER = "3212";
    public static final String ANNUITY_BILL_NUMBER = "3202";
    private static final Random random = new Random(999999);

    public static String generateBillNumber() {

        return String.valueOf(10000000 + random.nextInt());
    }

}
