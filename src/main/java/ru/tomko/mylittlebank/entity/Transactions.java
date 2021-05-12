package ru.tomko.mylittlebank.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    private TransactionsTypes type;
    @Column(name = "amount")
    private int amount;
    @Column(name = "date_time")
    @Temporal(TemporalType.DATE)
    private Date dateTime;
    @Column(name = "account")
    @ManyToOne
    private Accounts accounts;

    public Transactions() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TransactionsTypes getType() {
        return type;
    }

    public void setType(TransactionsTypes type) {
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

    public Accounts getAccounts() {
        return accounts;
    }

    public void setAccounts(Accounts accounts) {
        this.accounts = accounts;
    }
}
