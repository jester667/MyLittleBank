package ru.tomko.mylittlebank.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountNumber;
    @Column(name = "amount")
    private int amount;
    @Column(name = "opening_date")
    @Temporal(TemporalType.DATE)
    private Date openingDate;
    @Column(name = "validity_period")
    @Temporal(TemporalType.DATE)
    private Date validityPeriod;
    @Column(name = "owner")
    @ManyToOne
    private User owner;

    public Account() {
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public Date getValidityPeriod() {
        return validityPeriod;
    }

    public void setValidityPeriod(Date validityPeriod) {
        this.validityPeriod = validityPeriod;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
