package ru.tomko.mylittlebank.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tomko.mylittlebank.entity.Transaction;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    public List<Transaction> getAllByDateTimeBetween(@NotNull(message = "date must be not empty") Date dateTime, @NotNull(message = "date must be not empty") Date dateTime2);
}
