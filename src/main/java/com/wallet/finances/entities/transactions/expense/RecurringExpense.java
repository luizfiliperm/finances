package com.wallet.finances.entities.transactions.expense;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.wallet.finances.entities.transactions.expense.enums.RecurringType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "recurring_expense")
public class RecurringExpense extends Expense{
    
    @Column(name = "installments_number")
    private Integer installmentsNumber;
    
    @Column(name = "recurring_type")
    private RecurringType RecurringType;

    @Column(name = "total_value")
    private BigDecimal totalValue;

    @Column(name = "missing_value")
    private BigDecimal missingValue;

    public RecurringExpense(){}

    public RecurringExpense(Long id, String name, BigDecimal value, LocalDate date){
        super(id, name, value, date);
    }

    public Integer getInstallmentsNumber() {
        return installmentsNumber;
    }

    public void setInstallmentsNumber(Integer installmentsNumber) {
        this.installmentsNumber = installmentsNumber;
    }

    public RecurringType getRecurringType() {
        return RecurringType;
    }

    public void setRecurringType(RecurringType recurringType) {
        RecurringType = recurringType;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public BigDecimal getMissingValue() {
        return missingValue;
    }

    public void setMissingValue(BigDecimal missingValue) {
        this.missingValue = missingValue;
    }

    
}
