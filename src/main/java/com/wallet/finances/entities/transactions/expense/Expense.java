package com.wallet.finances.entities.transactions.expense;

import com.wallet.finances.entities.transactions.Transaction;
import com.wallet.finances.entities.transactions.enums.PaymentMethod;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Expense extends Transaction {
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = true)
    private ExpenseCategory expenseCategory;
    public Expense() {
    }
    public Expense(Long id, String name, BigDecimal value, Date date) {
        super(id, name, value, date);
    }
}
