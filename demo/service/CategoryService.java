package com.pfm.demo.service;

import com.pfm.demo.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategory();

    Category getCategoryById(Long id);

    Category createCategory(Category category);


    List<Category> getCategoriesByName(String name);


    void deleteCategoryAndRelatedTransactions(Long categoryId);
}
