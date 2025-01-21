package com.example.financetracker.controller;

import com.example.financetracker.model.Expenses;
import com.example.financetracker.service.ExpensesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/expenses")
public class ExpensesController {

    private final ExpensesService expenseService;

    ExpensesController(ExpensesService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public ResponseEntity<List<Expenses>> getAllExpenses() {
        List<Expenses> expenses = expenseService.getAllExpenses();

        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<Expenses> getExpenseById(@PathVariable Long id) {
        Optional<Expenses> expense  = expenseService.getExpensesById(id);

        return expense.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Expenses> createExpense(@RequestBody Expenses expense) {
        Expenses createdExpense = expenseService.addExpenses(expense);
        return ResponseEntity.ok(createdExpense);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpenseById(@PathVariable Long id) {
        boolean isDeleted = expenseService.deleteExpensesById(id);
        return isDeleted ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

}
