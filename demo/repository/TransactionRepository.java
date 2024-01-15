package com.pfm.demo.repository;

import com.pfm.demo.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByCategoryId(Long categoryId);
    void deleteByCategoryId(Long categoryId);

}