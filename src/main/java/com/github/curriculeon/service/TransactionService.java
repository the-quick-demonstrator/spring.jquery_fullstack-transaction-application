package com.github.curriculeon.service;

import com.github.curriculeon.model.Account;
import com.github.curriculeon.model.Transaction;
import com.github.curriculeon.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    private AccountRepository repository;

    private Account transact(Transaction transaction) {
        Long accountId = transaction.getAccountId();
        Account account = repository.findById(accountId).get();
        Double currentBalance = account.getBalance();
        Double transactionDelta = transaction.getDeposit() - transaction.getWithdrawal();
        Double newBalance = currentBalance + transactionDelta;
        account.setBalance(newBalance);
        return repository.save(account);
    }

    public Account withdrawal(Long accountId, double withdrawal) {
        return transact(new Transaction(accountId, withdrawal, 0));
    }

    public Account deposit(Long accountId, double deposit) {
        return transact(new Transaction(accountId, 0, deposit));
    }

}
