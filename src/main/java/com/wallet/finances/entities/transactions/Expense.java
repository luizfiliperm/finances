package com.wallet.finances.entities.transactions;

import com.wallet.finances.Enum.PaymentMethod;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Expense extends Transaction {
    @Column(name = "payment_Method")
    private PaymentMethod paymentMethod;
    public Expense() {
    }

    public Expense(Long id, String name, BigDecimal value, Date date, PaymentMethod paymentMethod) {
        super(id, name, value, date);
        this.paymentMethod = paymentMethod;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
