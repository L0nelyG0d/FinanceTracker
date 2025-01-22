package com.example.financetracker.service;

import com.example.financetracker.model.Expenses;
import com.example.financetracker.repository.ExpensesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpensesService {

    private final ExpensesRepository expensesRepository;

    public ExpensesService(ExpensesRepository expensesRepository) {
        this.expensesRepository = expensesRepository;
    }

    public List<Expenses> getAllExpenses() {
        return expensesRepository.findAll();
    }

    public Optional<Expenses> getExpensesById(Long id) {
        return expensesRepository.findById(id);
    }

    public Expenses addExpenses(Expenses expense) {
        return expensesRepository.save(expense);
    }

    public boolean deleteExpensesById(Long id) {
        if (expensesRepository.existsById(id)) {
            expensesRepository.deleteById(id);
            return true;
        }
        return false;
    }
}