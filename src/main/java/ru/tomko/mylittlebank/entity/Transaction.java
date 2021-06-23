package ru.tomko.mylittlebank.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(value = EnumType.STRING)
    @JoinColumn(name = "type")
    @NotNull(message = "type must be not empty")
    private TransactionType type;
    @Column(name = "amount")
    @Positive(message = "amount must be positive")
    private int amount;
    @Column(name = "date_time")
    @Temporal(TemporalType.DATE)
    @NotNull(message = "date must be not empty")
    private Date dateTime;
    @ManyToOne
    @JoinColumn(name = "account")
    @NotNull(message = "account must be not empty")
    private Account account;

    public Transaction() {

    }

    public Transaction(@NotNull(message = "type must be not empty") TransactionType type,
                       @Positive(message = "amount must be positive") int amount,
                       @NotNull(message = "date must be not empty") Date dateTime,
                       @NotNull(message = "account must be not empty") Account account) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.dateTime = dateTime;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Account getAccounts() {
        return account;
    }

    public void setAccounts(Account account) {
        this.account = account;
    }
}
