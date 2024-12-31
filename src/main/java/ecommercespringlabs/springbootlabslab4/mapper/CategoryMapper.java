package ecommercespringlabs.springbootlabslab4.mapper;

import ecommercespringlabs.springbootlabslab4.domain.Author;
import ecommercespringlabs.springbootlabslab4.domain.Category;
import ecommercespringlabs.springbootlabslab4.dto.category.CategoryResponseDto;
import ecommercespringlabs.springbootlabslab4.repository.entity.AuthorEntity;
import ecommercespringlabs.springbootlabslab4.repository.entity.CategoryEntity;

import java.util.List;

public interface CategoryMapper {
    Category toCategory(CategoryEntity categoryEntity);
    CategoryResponseDto toCategoryResponseDto(Category category);
    List<Category> toCategoryList(List<CategoryEntity> categoryEntities);
    List<CategoryResponseDto> toCategoryResponseDtoList(List<Category> categoryList);
    Category toCategoryFromEntity(CategoryEntity categoryEntity);
    CategoryEntity toCategoryEntity(Category category);
}

