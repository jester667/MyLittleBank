package ru.tomko.mylittlebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.tomko.mylittlebank.dao.TransactionRepository;
import ru.tomko.mylittlebank.entity.Transaction;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("transactions")
public class TransactionController {
    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Transaction> getTransaction(@PathVariable int id) {
        return transactionRepository.findById(id);
    }

    @GetMapping("{startDate}/{endDate}")
    public List<Transaction> getAllTransactionsByDateBetween(@PathVariable Date startDate, @PathVariable Date endDate) {
        return transactionRepository.getAllByDateTimeBetween(startDate, endDate);
    }

    @PostMapping
    public ResponseEntity<String> addTransaction(@RequestBody @Valid Transaction transaction) {
        transactionRepository.save(transaction);
        return ResponseEntity.ok("transaction is valid");
    }

    @PutMapping
    public ResponseEntity<String> updateTransaction(@RequestBody @Valid Transaction transaction) {
        transactionRepository.save(transaction);
        return ResponseEntity.ok("transaction is valid");
    }

    @DeleteMapping("{id}")
    public void deleteTransaction(@PathVariable int id) {
        transactionRepository.deleteById(id);
    }
}
