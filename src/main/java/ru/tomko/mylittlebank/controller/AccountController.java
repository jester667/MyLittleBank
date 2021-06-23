package ru.tomko.mylittlebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ru.tomko.mylittlebank.dao.AccountRepository;
import ru.tomko.mylittlebank.entity.Account;
import ru.tomko.mylittlebank.entity.Exchange;
import ru.tomko.mylittlebank.exception.FailedTransactionException;
import ru.tomko.mylittlebank.service.ExchangeService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("accounts")
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private ExchangeService exchangeService;

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Account> getAccount(@PathVariable int id) {
        return accountRepository.findById(id);
    }

    @PostMapping
    public ResponseEntity<String> addAccount(@RequestBody @Valid Account account) {
        accountRepository.save(account);
        return ResponseEntity.ok("account is valid");
    }

    @PostMapping("/exchange")
    public ResponseEntity<String> exchangeMoney(@RequestBody @Valid Exchange exchange) throws FailedTransactionException {
        if (!exchangeService.exchangeMoney(exchange.getFromAcc().getAccountNumber(), exchange.getToAcc().getAccountNumber(), exchange.getAmount())) {
            throw new FailedTransactionException("Не удалось осуществить перевод");
        }
        return ResponseEntity.ok("Success");
    }

    @PutMapping
    public ResponseEntity<String> updateAccount(@RequestBody Account account) {
        accountRepository.save(account);
        return ResponseEntity.ok("account is valid");
    }

    @DeleteMapping("{id}")
    public void deleteAccount(@PathVariable int id) {
        accountRepository.deleteById(id);
    }
}
