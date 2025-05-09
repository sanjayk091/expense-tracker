package com.expense.tracker.Controller;

import com.expense.tracker.DTO.ExpenseRequestDTO;
import com.expense.tracker.DTO.ExpenseResponseDTO;
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
    public ResponseEntity<ExpenseResponseDTO> create(@RequestBody ExpenseRequestDTO expense) {
        ExpenseResponseDTO savedExpense = service.saveExpense(expense);
        return ResponseEntity.ok(savedExpense);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing expense by ID")
    public ResponseEntity<ExpenseResponseDTO> updateExpense(
            @PathVariable("id") Long id,
            @RequestBody ExpenseRequestDTO expenseRequestDTO) {

        ExpenseResponseDTO updatedExpense = service.updateExpense(id, expenseRequestDTO);
        return ResponseEntity.ok(updatedExpense);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get an expense by ID")
    public ResponseEntity<ExpenseResponseDTO> getById(@PathVariable("id") Long id){
        ExpenseResponseDTO receivedExpense = service.getExpenseById(id);
        return ResponseEntity.ok(receivedExpense);
    }

    @Operation(summary = "List all expenses")
    @GetMapping("/list")
    public List<ExpenseResponseDTO> getAll() {
        return service.getAllExpenses();
    }

    @Operation(summary = "List expenses by category")
    @GetMapping("/category/{category}")
    public List<ExpenseResponseDTO> getByCategory(@PathVariable("category") String category) {
        return service.getExpensesByCategory(category);
    }

    @Operation(summary = "Get total of all expenses")
    @GetMapping("/total/all")
    public BigDecimal getTotalExpense() {
        return service.getTotalExpense();
    }

    @Operation(summary = "Get total expense for a specific category")
    @GetMapping("/total/category/{category}")
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
