package com.example.financetracker.model;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "expenses")
public class Expenses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull
    private int amount;

    @Column(length = 255)
    private String description;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String category;

    @Column(name = "payment_method")
    private String paymentMethod;

    public Expenses() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Expenses{" +
                "id=" + id +
                ", amount=" + amount +
                ", category='" + category + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }

}