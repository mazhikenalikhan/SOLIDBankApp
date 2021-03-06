package com.example.SOLIDBankApp.Account;

import com.example.SOLIDBankApp.Account.Creation.BankCore;
import com.example.SOLIDBankApp.Account.Creation.CreateAccountOperationUI;
import com.example.SOLIDBankApp.Account.Listing.AccountListingService;

public class AccountBasicCLI {
    private final CreateAccountOperationUI createAccountOperationUI;
    private final BankCore bankCore;
    private final AccountListingService accountListing;

    public AccountBasicCLI(CreateAccountOperationUI createAccountOperationUI, BankCore bankCore, AccountListingService accountListing){
        this.accountListing = accountListing;
        this.bankCore = bankCore;
        this.createAccountOperationUI = createAccountOperationUI;
    }

    public void createAccountRequest(String clientID) {
        bankCore.createNewAccount(createAccountOperationUI.requestAccountType(), clientID);
    }

    public void getAccounts(String clientID) {
        System.out.println(accountListing.getClientAccounts(clientID));
    }
}
