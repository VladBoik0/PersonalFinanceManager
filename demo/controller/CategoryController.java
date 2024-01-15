package com.pfm.demo.controller;

import com.pfm.demo.model.Category;
import com.pfm.demo.model.Transaction;
import com.pfm.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategory();
    }

    @PutMapping("/create/{name}/{description}")
    public Category createCategory(@PathVariable String name, @PathVariable String description) {
        Category category = new Category();
        category.setName(name);
        category.setDescription(description);
        return categoryService.createCategory(category);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteCategoryById(@PathVariable("id") Long id) {
        categoryService.deleteCategoryById(id);
    }

    @GetMapping("/search/{name}")
    public List<Category> getCategoriesByName(@PathVariable String name) {
        return categoryService.getCategoriesByName(name);
    }
}

