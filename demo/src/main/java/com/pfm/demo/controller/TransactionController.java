package com.pfm.demo.controller;

import com.pfm.demo.model.Transaction;
import com.pfm.demo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/all")
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }


    @PutMapping("/{categoryId}/{type}/{sum}/{date}/{description}")
    public Transaction createNewTransaction(@PathVariable("categoryId") Long categoryId,
                                             @PathVariable("type") String type,
                                             @PathVariable("sum") Optional<Double> sum,
                                             @PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
                                             @PathVariable("description") String description) {
        double sumValue = sum.orElse(0.0);

        return transactionService.createTransaction(categoryId, type, sumValue, date, description);

    }

    @PostMapping("/{id}/{categoryId}/{type}/{sum}/{date}/{description}")
    public Transaction updateTransaction(@PathVariable("id") Long id,
                                          @PathVariable("categoryId") Long categoryId,
                                          @PathVariable("type") String type,
                                          @PathVariable("sum") Optional<Double> sum,
                                          @PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
                                          @PathVariable("description") String description) {
        double sumValue = sum.orElse(0.0);
        return transactionService.updateTransaction(id, categoryId, type, sumValue, date, description);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTransactionById(@PathVariable Long id) {
        transactionService.deleteTransactionById(id);
    }

    @GetMapping("/category/{categoryId}")
    public List<Transaction> getTransactionsByCategory(@PathVariable Long categoryId) {
        return transactionService.getTransactionsByCategoryId(categoryId);
    }


}

