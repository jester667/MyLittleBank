package ru.tomko.mylittlebank.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tomko.mylittlebank.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User getByFullName(String name);
    public User getByPhone(String phone);
    public User getByEmail(String email);
}
