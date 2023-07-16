package com.wallet.finances.repositories;

import com.wallet.finances.entities.transactions.expense.ExpenseCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<ExpenseCategory, Long> {
}
