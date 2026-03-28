package entity;

import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "accounts")
@Cacheable
public class Account {

    @Id
    private int accountNumber;

    private String name;
    private double balance;
    private int pin; 

    public Account() {}

    public Account(int accountNumber, String name, int pin) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.pin = pin;
        this.balance = 0.0;
    }

    public int getAccountNumber() { return accountNumber; }
    public String getName() { return name; }
    public double getBalance() { return balance; }
    public int getPin() { return pin; }

    public void setBalance(double balance) { this.balance = balance; }
    public void setPin(int pin) { this.pin = pin; }
}