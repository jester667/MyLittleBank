package ru.tomko.mylittlebank.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_number")
    private int accountNumber;
    @Column(name = "amount")
    @Positive(message = "amount must be positive")
    private int amount;
    @Column(name = "opening_date")
    @Temporal(TemporalType.DATE)
    @NotNull(message = "opening date must be not empty")
    private Date openingDate;
    @Column(name = "validity_period")
    @Temporal(TemporalType.DATE)
    @NotNull(message = "validity period must be not empty")
    private Date validityPeriod;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner")
    @NotNull(message = "owner must be not empty")
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
