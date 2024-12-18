package com.training.expensetracker.controller;

import com.training.expensetracker.model.Expense;
import com.training.expensetracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;

    @GetMapping("/expense")
    ResponseEntity<?> getAllExpense() {
        return new ResponseEntity<>(expenseService.getAllExpense(), HttpStatus.OK);
    }

    @PostMapping("/expense")
    ResponseEntity<?> addExpense(@RequestBody Expense expense) {
        expenseService.addExpense(expense);
        return new ResponseEntity<>( expenseService.getAllExpense() ,HttpStatus.OK);
    }

    @PostMapping("/expensebyidcategory")
    ResponseEntity<?> getExpenseById(@RequestParam(required = false) Integer id , @RequestParam(required = false) String category) {
        return new ResponseEntity<>(expenseService.getExpenseByIdCategory(id,category), HttpStatus.OK);
    }

    @PostMapping("/expenseupdate")
    ResponseEntity<?> updateExpense(@RequestBody Expense expense) {

        return new ResponseEntity<>(expenseService.updateExpense(expense), HttpStatus.OK);
    }

    @PostMapping("/expensedeletebyid")
    ResponseEntity<?> deleteExpense(@RequestBody Expense expense) {
        expenseService.deleteExpenseById(expense.getId());
        return new ResponseEntity<>("Delete Successful", HttpStatus.OK);
    }

}
