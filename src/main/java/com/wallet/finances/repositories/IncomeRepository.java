package com.wallet.finances.repositories;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.wallet.finances.entities.transactions.income.Income;

public interface IncomeRepository extends JpaRepository<Income, Long>{
    
    List<Income> getAllByWalletId(Long walletId);

    void deleteByIdAndWalletId(Long id, Long walletId);

    List<Income> findAllByWalletIdAndDateBetween(
        Long walletId,
        LocalDate startDate,
        LocalDate endDate
    );
}
