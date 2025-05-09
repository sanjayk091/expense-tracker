package com.expense.tracker.Mapper;

import com.expense.tracker.DTO.ExpenseRequestDTO;
import com.expense.tracker.DTO.ExpenseResponseDTO;
import com.expense.tracker.Entity.ExpenseEntity;
import java.util.List;
import java.util.stream.Collectors;

public class ExpenseMapper {
    public static ExpenseEntity toEntity(ExpenseRequestDTO dto) {
        ExpenseEntity expense = new ExpenseEntity();
        expense.setCategory(dto.getCategory());
        expense.setAmount(dto.getAmount());
        expense.setDate(dto.getDate());
        expense.setDescription(dto.getDescription());
        return expense;
    }

    public static ExpenseResponseDTO toDto(ExpenseEntity expense) {
        ExpenseResponseDTO dto = new ExpenseResponseDTO();
        dto.setId(expense.getId());
        dto.setCategory(expense.getCategory());
        dto.setAmount(expense.getAmount());
        dto.setDate(expense.getDate());
        dto.setDescription(expense.getDescription());
        return dto;
    }

    public static List<ExpenseResponseDTO> toDto(List<ExpenseEntity> expenseEntities){
        return expenseEntities.stream()
                .map(ExpenseMapper::toDto)
                .collect(Collectors.toList());
    }
}
