package com.example.Spring.boot.project.service;

import com.example.Spring.boot.project.model.BankModel;
import com.example.Spring.boot.project.repo.BankRepository;
import com.example.Spring.boot.project.repo.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class BankService {
    @Autowired
    private BankRepository bankRepository;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void registerUser(BankModel bankModel) {
        String accountNumber = "AC" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        bankModel.setAccountNumber(accountNumber);
        bankModel.setPassword(passwordEncoder.encode(bankModel.getPassword()));
        bankRepository.save(bankModel);
    }

    public double checkBalance(String accountNumber) {
        return bankRepository.findByAccountNumber(accountNumber)
                .map(BankModel::getBalance)
                .orElseThrow(() -> new RuntimeException("Account not found!"));
    }

    public void deposit(String accountNumber, double amount) {
        BankModel user = bankRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found!"));

        user.setBalance(user.getBalance() + amount);
        bankRepository.save(user);
    }

    public void withdraw(String accountNumber, double amount) {
        BankModel user = bankRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found!"));

        if (user.getBalance() < amount) {
            throw new RuntimeException("Insufficient funds!");
        }

        user.setBalance(user.getBalance() - amount);
        bankRepository.save(user);
    }




}
