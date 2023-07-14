package com.wallet.finances.rest;

import com.wallet.finances.entities.Category;
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
    public List<Category> findAll(){
        return categoryService.findAll();
    }
    @PostMapping("/categories")
    public Category addCategory(@RequestBody Category category){
        category.setId(0L);
        return categoryService.save(category);
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
    public Category findById(@PathVariable Long id){
        return categoryService.findById(id);
    }
    @PutMapping("/categories")
    public Category updateCategory(@RequestBody Category category){
        return categoryService.save(category);
    }
}
