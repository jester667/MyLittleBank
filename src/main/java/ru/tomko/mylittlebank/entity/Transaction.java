package ru.tomko.mylittlebank.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    private TransactionType type;
    @Column(name = "amount")
    private int amount;
    @Column(name = "date_time")
    @Temporal(TemporalType.DATE)
    private Date dateTime;
    @Column(name = "account")
    @ManyToOne
    private Account account;

    public Transaction() {

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
