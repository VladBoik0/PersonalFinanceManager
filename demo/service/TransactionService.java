package com.pfm.demo.service;

import com.pfm.demo.model.Transaction;

import java.util.Date;
import java.util.List;

public interface TransactionService {
    List<Transaction> getAllTransactions();

    Transaction getTransactionById(Long id);

    void deleteTransactionById(Long id);

    Transaction updateTransaction(Long id, Long categoryId, String type, double sum, Date date, String description);

    Transaction createTransaction(Long categoryId, String type, double sum, Date date, String description);

    List<Transaction> getTransactionsByCategoryId(Long categoryId);
}
