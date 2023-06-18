package com.wallet.finances.services;

import java.util.List;

import com.wallet.finances.entities.Category;

public interface CategoryService {
    List<Category> findAll();
    
    Category findById(Long id);

    Category save(Category category);

    void deleteById(Long id);
}
