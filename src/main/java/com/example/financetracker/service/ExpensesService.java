package com.example.financetracker.service;

import com.example.financetracker.model.Expenses;
import com.example.financetracker.repository.ExpensesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpensesService {
    private ExpensesRepository expensesRepository;

    public ExpensesService(ExpensesRepository expensesRepository) {
        this.expensesRepository = expensesRepository;
    }

    public Expenses addExpenses(Expenses expenses) {
        return expensesRepository.save(expenses);
    }

    public Optional<Expenses> getExpensesById(Long id) {
        return expensesRepository.findById(id);
    }

    public List<Expenses> getAllExpenses() {
        return expensesRepository.findAll();
    }
    public boolean deleteExpensesById(Long id) {
        if (expensesRepository.existsById(id)) {
            expensesRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
