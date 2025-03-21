package com.example.Spring.boot.project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class BankModel {
    @Id
    private String accountNumber;
    private String name;
    private String email;
    private String mobileNumber;
    private String password;
    private double balance;

    public BankModel() {

    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile_number() {
        return mobileNumber;
    }

    public void setMobile_number(String mobile_number) {
        this.mobileNumber = mobile_number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    public BankModel(String accountNumber, String name, String email, String password, String mobileNumber, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.email = email;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.balance = balance;
    }


}
