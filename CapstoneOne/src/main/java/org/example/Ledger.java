package org.example;

import java.util.ArrayList;
import java.util.List;

public class Ledger {
    private List<Transaction> transactions; // Encapsulates a collection of transaction records
    //TODO under ledger method
    // searching ,filtering, reports holds transaction
    // it is static no getters and / setters

    public Ledger() {

        this.transactions = TransactionFileManager.readFile();// from existing transaction from file or creates empty list

    }

    public void addDeposit(Transaction transaction) {
        transactions.add(transaction);// append to in memory ledger
        TransactionFileManager.appendTransaction(transaction);// persist transaction to file
    }

    public void makePayment(Transaction transaction) {
        transactions.add(transaction);
        TransactionFileManager.appendTransaction(transaction);

    }
}
