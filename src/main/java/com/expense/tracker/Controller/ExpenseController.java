package com.expense.tracker.Controller;

import com.expense.tracker.Model.Expense;
import com.expense.tracker.Service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("api/expenses")
public class ExpenseController {
    @Autowired
    private ExpenseService service;

    // Save a new expense
    @PostMapping
    public Expense create(@RequestBody Expense expense) {
        return service.saveExpense(expense);
    }

    // Get all expenses
    @GetMapping
    public List<Expense> getAll() {
        return service.getAllExpenses();
    }

    // Get all expenses by category
    @GetMapping("/category/{category}")
    public List<Expense> getByCategory(@PathVariable String category) {
        return service.getExpensesByCategory(category);
    }

    // Get total expense
    @GetMapping("/total")
    public BigDecimal getTotalExpense() {
        return service.getTotalExpense();
    }

    // Get total expense for a specific category
    @GetMapping("/total/{category}")
    public BigDecimal getTotalByCategory(@PathVariable String category) {
        return service.getTotalExpenseByCategory(category);
    }

    // Delete an expense
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteExpense(id);
        return ResponseEntity.noContent().build();
    }
}
