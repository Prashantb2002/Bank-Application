package com.example.Spring.boot.project.repo;

import com.example.Spring.boot.project.model.BankModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankRepository extends JpaRepository<BankModel, String> {
    Optional<BankModel> findByAccountNumber(String accountNumber);
}
