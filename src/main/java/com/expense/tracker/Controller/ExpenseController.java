package com.expense.tracker.Controller;

import com.expense.tracker.Model.Expense;
import com.expense.tracker.Service.ExpenseService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Create a new expense")
    @PostMapping
    public Expense create(@RequestBody Expense expense) {
        return service.saveExpense(expense);
    }

    @Operation(summary = "Get all expenses")
    @GetMapping
    public List<Expense> getAll() {
        return service.getAllExpenses();
    }

    @Operation(summary = "Get all expenses by category")
    @GetMapping("/{category}")
    public List<Expense> getByCategory(@PathVariable("category") String category) {
        return service.getExpensesByCategory(category);
    }

    @Operation(summary = "Get total expense across all categories")
    @GetMapping("/total")
    public BigDecimal getTotalExpense() {
        return service.getTotalExpense();
    }

    @Operation(summary = "Get total expense for a specific category")
    @GetMapping(value = "/{category}/total")
    public BigDecimal getTotalByCategory(@PathVariable("category") String category) {
        return service.getTotalExpenseByCategory(category);
    }

    @Operation(summary = "Delete an expense by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeExpense(@PathVariable("id") Long id) {
        service.deleteExpense(id);
        return ResponseEntity.noContent().build();
    }
}
