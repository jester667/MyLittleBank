package ru.tomko.mylittlebank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tomko.mylittlebank.dao.AccountRepository;
import ru.tomko.mylittlebank.dao.TransactionRepository;
import ru.tomko.mylittlebank.entity.Account;
import ru.tomko.mylittlebank.entity.Transaction;

import java.util.Date;

import static ru.tomko.mylittlebank.entity.TransactionType.ACCRUAL;
import static ru.tomko.mylittlebank.entity.TransactionType.WITHDRAWAL;

@Service
public class ExchangeService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    @Transactional
    public boolean exchangeMoney(int fromAccId, int toAccId, int amount) {
        Account fromAcc = accountRepository.findById(fromAccId).get();
        Account toAcc = accountRepository.findById(toAccId).get();
        if (fromAcc.getAmount() < amount) {
            return false;
        }
        transactionRepository.save(new Transaction(WITHDRAWAL, amount, new Date(), fromAcc));
        transactionRepository.save(new Transaction(ACCRUAL, amount, new Date(), toAcc));
        return true;
    }
}
