package za.ac.cput.factory;

import za.ac.cput.domain.Bank;
import za.ac.cput.util.Helper;

public class BankFactory {
    public static Bank createBank(String name, Integer branchCode) {
        if(Helper.isNullOrEmpty(name) || Helper.isNullOrEmpty(branchCode)){
            return null;
        }
        return new Bank.Builder()
                .setName(name)
                .setBranchCode(branchCode)
                .build();
    }
}
