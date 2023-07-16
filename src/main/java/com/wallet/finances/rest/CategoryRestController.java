package com.wallet.finances.rest;

import com.wallet.finances.entities.transactions.expense.ExpenseCategory;
import com.wallet.finances.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryRestController {
    private CategoryService categoryService;
    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping("/categories")
    public List<ExpenseCategory> findAll(){
        return categoryService.findAll();
    }
    @PostMapping("/categories")
    public ExpenseCategory addCategory(@RequestBody ExpenseCategory expenseCategory){
        expenseCategory.setId(0L);
        return categoryService.save(expenseCategory);
    }
    @DeleteMapping("/categories/{id}")
    public String deleteCategory(@PathVariable Long id){
        if(categoryService.findById(id) == null){
            throw new RuntimeException("Category not found");
        }
        categoryService.deleteById(id);
        return "Category with id: "+ id +" deleted successfully";
    }
    @GetMapping("/categories/{id}")
    public ExpenseCategory findById(@PathVariable Long id){
        return categoryService.findById(id);
    }
    @PutMapping("/categories")
    public ExpenseCategory updateCategory(@RequestBody ExpenseCategory expenseCategory){
        return categoryService.save(expenseCategory);
    }
}
