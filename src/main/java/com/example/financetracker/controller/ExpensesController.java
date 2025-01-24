package com.example.financetracker.controller;

import com.example.financetracker.model.Expenses;
import com.example.financetracker.service.ExpensesService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/expenses")
public class ExpensesController {

    private final ExpensesService expensesService;

    public ExpensesController(ExpensesService expensesService) {
        this.expensesService = expensesService;
    }

    @GetMapping
    @ResponseBody
    public List<Expenses> getAllExpenses() {
        return expensesService.getAllExpenses();
    }

    @GetMapping("/getallexpenses")
    public String getTotalExpenses(Model model) {
        List<Expenses> expenses = expensesService.getAllExpenses();
        int totalExpenses = expenses.stream().mapToInt(Expenses::getAmount).sum(); // Calculate total

        model.addAttribute("expenses", expenses);
        model.addAttribute("totalExpenses", totalExpenses); // Add total expenses to the model

        return "expenses1"; // Ensure this maps to the Thymeleaf template correctly
    }

    @GetMapping("/add")
    public String getAddExpenseForm(Model model) {
        model.addAttribute("expense", new Expenses());
        return "add-expense";
    }

    @PostMapping("/add")
    public String addExpenseFromForm(
            @RequestParam int amount,
            @RequestParam String description,
            @RequestParam String date,
            @RequestParam String category,
            @RequestParam String paymentMethod) {

        Expenses expense = new Expenses();
        expense.setAmount(amount);
        expense.setDescription(description);
        expense.setDate(LocalDate.parse(date));
        expense.setCategory(category);
        expense.setPaymentMethod(paymentMethod);

        expensesService.addExpenses(expense);
        return "redirect:/expenses/getallexpenses";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpenseById(@PathVariable Long id) {
        boolean isDeleted = expensesService.deleteExpensesById(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}