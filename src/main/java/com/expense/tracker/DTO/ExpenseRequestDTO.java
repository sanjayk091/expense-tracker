package com.expense.tracker.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Getter
@Setter
@NoArgsConstructor
public class ExpenseRequestDTO {
    private String category;
    private BigDecimal amount;
    private LocalDate date;
    private String description;
}
