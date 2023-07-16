package com.wallet.finances.entities.transactions.expense;

import com.wallet.finances.entities.transactions.Transaction;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Expense extends Transaction {

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = true)
    private ExpenseCategory expenseCategory;

    public Expense() {
    }

    public Expense(Long id, String name, BigDecimal value, LocalDate date) {
        super(id, name, value, date);
    }

    public ExpenseCategory getExpenseCategory() {
        return expenseCategory;
    }
    public void setExpenseCategory(ExpenseCategory expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    
}
