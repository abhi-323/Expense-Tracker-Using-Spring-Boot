package com.training.expensetracker.repository;

import com.training.expensetracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
    Optional<Expense> findByCategory(String category);
}
