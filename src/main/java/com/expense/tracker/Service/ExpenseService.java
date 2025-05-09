package com.expense.tracker.Service;

import com.expense.tracker.DTO.ExpenseRequestDTO;
import com.expense.tracker.DTO.ExpenseResponseDTO;
import com.expense.tracker.Entity.ExpenseEntity;
import com.expense.tracker.Mapper.ExpenseMapper;
import com.expense.tracker.Repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;
    public ExpenseResponseDTO saveExpense(ExpenseRequestDTO expense){
        ExpenseEntity expenseRequest = ExpenseMapper.toEntity(expense);
        ExpenseEntity expenseSaved = expenseRepository.save(expenseRequest);
        return ExpenseMapper.toDto(expenseSaved);
    }

    public List<ExpenseResponseDTO> getAllExpenses() {
        List<ExpenseEntity> expenseReceived = expenseRepository.findAll();
        return ExpenseMapper.toDto(expenseReceived);
    }

    public List<ExpenseResponseDTO> getExpensesByCategory(String category) {
        List<ExpenseEntity> expenseReceived = expenseRepository.findByCategoryIgnoreCase(category);
        return ExpenseMapper.toDto(expenseReceived);
    }

    public BigDecimal getTotalExpense() {
        return expenseRepository.findAll().stream()
                .map(ExpenseEntity::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getTotalExpenseByCategory(String category) {
        return expenseRepository.findByCategoryIgnoreCase(category).stream()
                .map(ExpenseEntity::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }
}
