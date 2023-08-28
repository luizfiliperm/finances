package com.wallet.finances.entities.wallet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.wallet.finances.entities.transactions.Transaction;
import com.wallet.finances.entities.transactions.income.Income;
import com.wallet.finances.entities.user.User;

import jakarta.persistence.*;

@Entity
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "wallet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions;

    @Column(name = "total_income")
    private BigDecimal totalIncome;

    @Column(name = "total_expense")
    private BigDecimal totalExpense;

    @Transient
    private List<Income> incomes;

    public Wallet() {
        transactions = new ArrayList<>();
        this.totalExpense = BigDecimal.ZERO;
        this.totalIncome = BigDecimal.ZERO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void addTransaction(Transaction transaction){
        this.transactions.add(transaction);
        if(transaction instanceof Income){
            totalIncome.add(transaction.getValue());
        }else{
            totalExpense.add(transaction.getValue());
        }
    }

    public BigDecimal getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(BigDecimal totalIncome) {
        this.totalIncome = totalIncome;
    }

    public BigDecimal getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(BigDecimal totalExpense) {
        this.totalExpense = totalExpense;
    }

    public List<Income> getIncomes() {
        return incomes;
    }

    public void setIncomes(List<Income> incomes) {
        this.incomes = incomes;
    }
    

    public void calculateTotalIncome(){
        BigDecimal totalIncome = BigDecimal.ZERO;

        for(Income income : incomes){
            totalIncome = totalIncome.add(income.getValue());
        }

        this.totalIncome = totalIncome;
    }

    public void calculateTotalExpense(){
        BigDecimal totalExpense = BigDecimal.ZERO;

        for(Transaction transaction : transactions){
            if(transaction instanceof Income){
                Income income = (Income) transaction;
                totalExpense = totalExpense.add(income.getValue());
            }
        }

        this.totalExpense = totalExpense;
    }
    
}

