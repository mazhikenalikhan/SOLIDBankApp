package com.example.SOLIDBankApp.Transactions.Deposit;

import com.example.SOLIDBankApp.Account.Accounts.Account;
import com.example.SOLIDBankApp.Transactions.Service.TransactionDataService;
import com.example.SOLIDBankApp.Transactions.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public class TransactionDeposit {
    private final AccountDepositService accountDepositService;
    @Autowired
    private TransactionDataService transactionDataService;

    public TransactionDeposit(AccountDepositService accountDepositService){
        this.accountDepositService = accountDepositService;
    }

    public void execute(Account account, double amount){
        if(amount <= 0){
            System.out.println("FAILED: Incorrect data");
            return;
        }
        accountDepositService.deposit(amount, account);
        Transaction transaction = new Transaction(transactionDataService.getID(), account, amount);
        transactionDataService.addTransaction(transaction);
        System.out.println("SUCCESS");
    }
}
