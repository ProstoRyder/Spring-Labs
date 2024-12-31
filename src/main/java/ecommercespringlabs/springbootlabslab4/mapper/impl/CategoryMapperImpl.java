package ecommercespringlabs.springbootlabslab4.mapper.impl;

import ecommercespringlabs.springbootlabslab4.domain.Author;
import ecommercespringlabs.springbootlabslab4.domain.Category;
import ecommercespringlabs.springbootlabslab4.dto.category.CategoryResponseDto;
import ecommercespringlabs.springbootlabslab4.mapper.CategoryMapper;
import ecommercespringlabs.springbootlabslab4.repository.entity.AuthorEntity;
import ecommercespringlabs.springbootlabslab4.repository.entity.CategoryEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryMapperImpl implements CategoryMapper {
    @Override
    public Category toCategory(CategoryEntity categoryEntity) {
        return Category.builder()
                .id(categoryEntity.getId().toString())
                .title(categoryEntity.getTitle())
                .build();
    }

    @Override
    public CategoryResponseDto toCategoryResponseDto(Category category) {
        return CategoryResponseDto.builder()
                .id(category.getId())
                .title(category.getTitle())
                .build();
    }


    @Override
    public List<Category> toCategoryList(List<CategoryEntity> categoryEntities) {
        return categoryEntities.stream().map(this::toCategory).toList();
    }

    @Override
    public List<CategoryResponseDto> toCategoryResponseDtoList(List<Category> categoryList) {
        return categoryList.stream().map(this::toCategoryResponseDto).toList();
    }

    @Override
    public Category toCategoryFromEntity(CategoryEntity categoryEntity) {
        return Category.builder()
                .id(String.valueOf(categoryEntity.getId()))
                .title(categoryEntity.getTitle())
                .build();
    }

    @Override
    public CategoryEntity toCategoryEntity(Category category) {
        return CategoryEntity.builder()
                .id(Long.valueOf(category.getId()))
                .title(category.getTitle())
                .build();
    }
}
