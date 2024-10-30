package com.training.expensetracker.service;

import com.training.expensetracker.exceptions.MissingValueException;
import com.training.expensetracker.exceptions.ResourceNotFoundException;
import com.training.expensetracker.model.Expense;
import com.training.expensetracker.model.User;
import com.training.expensetracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    ExpenseRepository expenseRepository;

    public void validate(Expense expense) throws MissingValueException {
        if(expense.getAmount() == null || expense.getCategory() == null || expense.getTitle() == null ) {
            throw new MissingValueException();
        }
    }

    public void addExpense(Expense expense) {
        validate(expense);
        expenseRepository.save(expense);
    }

    public List<Expense> getAllExpense() {
        return expenseRepository.findAll();
    }

    public Expense getExpenseById(int id) throws ResourceNotFoundException {
        Optional<Expense> existingExpense = expenseRepository.findById(id);
        if (existingExpense.isPresent()) {
            return existingExpense.get();
        } else {
            throw new ResourceNotFoundException("Expense", "id", id);
        }
    }

    public Expense getExpenseByIdCategory(Integer id, String category) throws ResourceNotFoundException {
        Optional<Expense> existingExpense;
        if( id != null){
            existingExpense = expenseRepository.findById(id);
        }
        else {
            existingExpense = expenseRepository.findByCategory(category);
        }
        if (existingExpense.isPresent()) {
            return existingExpense.get();
        } else {
            throw new ResourceNotFoundException("Expense", "id", id);
        }
    }

    public Expense updateExpense(Expense userInputExpense) {
        validate(userInputExpense);
        Expense existingExpense = getExpenseById(userInputExpense.getId());
        validate(existingExpense);
        existingExpense.setAmount(userInputExpense.getAmount());
        existingExpense.setCategory(userInputExpense.getCategory());
        existingExpense.setTitle(userInputExpense.getTitle());
        expenseRepository.save(existingExpense);
        return existingExpense;
    }

    public void deleteExpenseById(int id) throws ResourceNotFoundException {
        getExpenseById(id);
        expenseRepository.deleteById(id);
    }


}
