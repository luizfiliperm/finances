package com.wallet.finances.services.impl;

import com.wallet.finances.repositories.CategoryRepository;
import com.wallet.finances.entities.transactions.expense.ExpenseCategory;
import com.wallet.finances.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<ExpenseCategory> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public ExpenseCategory findById(Long id) {
        Optional<ExpenseCategory> result = categoryRepository.findById(id);
        if(!result.isPresent()){
            throw new RuntimeException("Category not found");
        } return result.get();
    }

    @Override
    public ExpenseCategory save(ExpenseCategory expenseCategory) {
        return categoryRepository.save(expenseCategory);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
