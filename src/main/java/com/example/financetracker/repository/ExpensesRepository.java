package com.example.financetracker.repository;

import com.example.financetracker.model.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ExpensesRepository extends JpaRepository<Expenses, Long> {
    Expenses findByCategory(String category);
}
