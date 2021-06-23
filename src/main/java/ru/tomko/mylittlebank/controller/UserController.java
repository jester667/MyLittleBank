package ru.tomko.mylittlebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import ru.tomko.mylittlebank.dao.UserRepository;
import ru.tomko.mylittlebank.entity.User;

import javax.validation.Valid;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody @Valid User user) throws IOException {
        userRepository.save(user);
        return ResponseEntity.ok("User data is valid");
    }

    @PutMapping
    public ResponseEntity<String> updateEmployee(@RequestBody @Valid User user) {
        userRepository.save(user);
        return ResponseEntity.ok("User data is valid");
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<User> getUser(@PathVariable int id) {
        return userRepository.findById(id);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }

    @GetMapping("/name/{name}")
    public User getUserByFullName(@PathVariable String name) {
        return userRepository.getByFullName(name);
    }

    @GetMapping("/phone/{phone}")
    public User getUserByPhone(@PathVariable String phone) {
        return userRepository.getByPhone(phone);
    }

    @GetMapping("/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userRepository.getByEmail(email);
    }

}
