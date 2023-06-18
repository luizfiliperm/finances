package com.wallet.finances.dao;

import java.util.List;

import com.wallet.finances.entities.Category;

public interface CategoryDAO {
    List<Category> findAll();
    
    Category findById(Long id);

    Category save(Category category);

    void deleteById(Long id);
}
