package com.pfm.demo.service;

import com.pfm.demo.model.Transaction;
import com.pfm.demo.model.Category;
import com.pfm.demo.repository.CategoryRepository;
import com.pfm.demo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final CategoryService categoryService;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository, CategoryService categoryService) {
        this.transactionRepository = transactionRepository;
        this.categoryService = categoryService;
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction getTransactionById(Long id) {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);
        if (optionalTransaction.isEmpty()) {
            throw new IllegalStateException("Transaction with id " + id + " does not exist");
        }
        return optionalTransaction.get();
    }



    @Override
    public void deleteTransactionById(Long id) {
        transactionRepository.deleteById(id);
    }

    @Override
    public Transaction createTransaction(Long categoryId, String type, double sum, Date date, String description) {
        Category category = categoryService.getCategoryById(categoryId);
        Transaction transaction = new Transaction(category, type, sum, date, description);
        return transactionRepository.save(transaction);
    }
    @Override
    public Transaction updateTransaction(Long id, Long categoryId, String type, double sumValue, Date date, String description) {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);
        if (optionalTransaction.isEmpty()) {
            throw new IllegalStateException("Transaction with id " + id + " does not exist");
        }

        Transaction transaction = optionalTransaction.get();
        Category category = categoryService.getCategoryById(categoryId);
        transaction.setCategory(category);
        transaction.setType(type);
        transaction.setSum(sumValue);
        transaction.setDate(date);
        transaction.setDescription(description);

        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> getTransactionsByCategoryId(Long categoryId) {
        return transactionRepository.findByCategoryId(categoryId);}
}

