package ecommercespringlabs.springbootlabslab4.service;

import ecommercespringlabs.springbootlabslab4.domain.Category;
import ecommercespringlabs.springbootlabslab4.dto.category.CategoryRequestDto;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategories();
    Category findCategoryById(Long id);
    Category addCategory(CategoryRequestDto categoryRequestDto);
    void deleteCategory(Long id);
    Category updateCategory(CategoryRequestDto categoryRequestDto, Long id);
}
