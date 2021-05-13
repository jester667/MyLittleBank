package ru.tomko.mylittlebank.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tomko.mylittlebank.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
