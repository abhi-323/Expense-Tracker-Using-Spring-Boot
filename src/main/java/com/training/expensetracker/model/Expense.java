package com.training.expensetracker.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "expense")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name ="category", nullable = false)
    private String category;

}
