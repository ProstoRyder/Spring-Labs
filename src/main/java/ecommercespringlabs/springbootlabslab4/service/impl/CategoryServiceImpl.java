package ecommercespringlabs.springbootlabslab4.service.impl;

import ecommercespringlabs.springbootlabslab4.domain.Category;
import ecommercespringlabs.springbootlabslab4.dto.category.CategoryRequestDto;
import ecommercespringlabs.springbootlabslab4.mapper.CategoryMapper;
import ecommercespringlabs.springbootlabslab4.repository.CategoryRepository;
import ecommercespringlabs.springbootlabslab4.repository.entity.CategoryEntity;
import ecommercespringlabs.springbootlabslab4.service.CategoryService;
import ecommercespringlabs.springbootlabslab4.service.exception.CategoryNotFoundException;
import jakarta.persistence.PersistenceException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    private CategoryMapper categoryMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Category> findAllCategories() {
        return categoryMapper.toCategoryList(categoryRepository.findAll());
    }

    @Override
    public Category findCategoryById(Long id) {
        return categoryMapper.toCategory(categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id.toString())));
    }

    @Override
    public Category addCategory(CategoryRequestDto categoryRequestDto) {
        CategoryEntity categoryEntity = CategoryEntity.builder()
                .title(categoryRequestDto.getTitle())
                .build();
        try {
            return categoryMapper.toCategory(categoryRepository.save(categoryEntity));
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    public void deleteCategory(Long id) {
        findCategoryById(id);
        try {
            categoryRepository.deleteById(id);
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    public Category updateCategory(CategoryRequestDto categoryRequestDto, Long id) {
        CategoryEntity category = categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(id.toString()));
        category.setTitle(categoryRequestDto.getTitle());
        try {
            return categoryMapper.toCategory(categoryRepository.save(category));
        } catch (Exception e) {
            throw new PersistenceException(e);
        }

    }
}
