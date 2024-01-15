package com.pfm.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    private String type;
    private double sum;
    private Date date;
    private String description;

    public Transaction(Category category, String type, double sum, Date date, String description) {
        this.category = category;
        this.type = type;
        this.sum = sum;
        this.date = date;
        this.description = description;
    }
}