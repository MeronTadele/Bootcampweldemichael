package org.example;

import java.util.ArrayList;
import java.util.List;

public class Ledger {
    private List<Transaction> transactions;
    //TODO under ledger method
    // searching ,filtering, reports holds transaction
    // it is static no getters and / setters

    public Ledger() {

        this.transactions=TransactionFileManager.readFile();// creates empty list

    }

    public void addDeposit(Transaction transaction) {
        transactions.add(transaction);
       TransactionFileManager.appendTransaction(transaction);
    }
    public void makePayment(Transaction transaction){
        transactions.add(transaction);
        TransactionFileManager.appendTransaction(transaction);

    }

}
