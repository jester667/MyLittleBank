package ru.tomko.mylittlebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import ru.tomko.mylittlebank.dao.AccountRepository;
import ru.tomko.mylittlebank.entity.Account;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("accounts")
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;

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
