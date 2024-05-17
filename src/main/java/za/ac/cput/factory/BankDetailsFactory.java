package za.ac.cput.factory;

import za.ac.cput.domain.Bank;
import za.ac.cput.domain.BankDetails;
import za.ac.cput.util.Helper;

public class BankDetailsFactory {
    public static BankDetails createBankDetails(Bank bank, Long accountNumber, char accountType) {
        if(Helper.isNullOrEmpty(bank) || Helper.isNullOrEmpty(accountNumber) || Helper.isNullOrEmpty(accountType)){
            return null;
        }
        return new BankDetails.Builder()
                .setBank(bank)
                .setAccountNumber(accountNumber)
                .setAccountType(accountType)
                .build();
    }
}
