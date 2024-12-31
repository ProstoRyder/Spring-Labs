package ecommercespringlabs.springbootlabslab4.web;

import ecommercespringlabs.springbootlabslab4.domain.Category;
import ecommercespringlabs.springbootlabslab4.dto.category.CategoryRequestDto;
import ecommercespringlabs.springbootlabslab4.dto.category.CategoryResponseDto;
import ecommercespringlabs.springbootlabslab4.mapper.CategoryMapper;
import ecommercespringlabs.springbootlabslab4.service.CategoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@AllArgsConstructor
@Validated
public class CategoryController {
    private CategoryService categoryService;
    private CategoryMapper categoryMapper;

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryMapper.toCategoryResponseDto(categoryService.findCategoryById(id)));
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDto>> getAllCategories() {
        return ResponseEntity.ok(categoryMapper.toCategoryResponseDtoList(categoryService.findAllCategories()));
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDto> addCategory(@RequestBody @Valid CategoryRequestDto categoryRequestDto) {
        return ResponseEntity.ok(categoryMapper.toCategoryResponseDto(categoryService.addCategory(categoryRequestDto)));
    }

    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable Long categoryId) {
        categoryService.deleteCategory(categoryId);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryResponseDto> updateCategory(@RequestBody @Valid CategoryRequestDto categoryRequestDto, @PathVariable Long categoryId) {
        Category category = categoryService.updateCategory(categoryRequestDto, categoryId);
        return ResponseEntity.ok(categoryMapper.toCategoryResponseDto(category));
    }

}
