package ecommercespringlabs.springbootlabslab4.web;

import ecommercespringlabs.springbootlabslab4.domain.NewsItem;
import ecommercespringlabs.springbootlabslab4.dto.news.NewsItemRequestDto;
import ecommercespringlabs.springbootlabslab4.dto.news.NewsItemResponseDto;
import ecommercespringlabs.springbootlabslab4.mapper.NewsItemMapper;
import ecommercespringlabs.springbootlabslab4.repository.entity.NewsItemEntity;
import ecommercespringlabs.springbootlabslab4.service.NewsItemService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/news")
@Validated
@AllArgsConstructor
public class NewsItemController {

    private NewsItemService newsItemService;
    private NewsItemMapper newsItemMapper;

    @GetMapping("/{id}")
    public ResponseEntity<NewsItemResponseDto> getNewsItemById(@PathVariable Long id) {
        return ResponseEntity.ok(newsItemMapper.toNewsItemResponseDto(newsItemService.findNewsItemById(id)));
    }

    @GetMapping
    public ResponseEntity<List<NewsItemResponseDto>> getAllNewsItems() {
        return ResponseEntity.ok(newsItemMapper.toNewsItemResponseDtoList(newsItemService.findAllNewsItems()));
    }

    @PostMapping
    public ResponseEntity<NewsItemResponseDto> addCNewsItem(@RequestBody @Valid NewsItemRequestDto newsItemRequestDto) {
        return ResponseEntity.ok(newsItemMapper.toNewsItemResponseDto(newsItemService.addNewsItem(newsItemRequestDto)));
    }

    @DeleteMapping("/{newsItemId}")
    public void deleteNewsItem(@PathVariable Long newsItemId) {
        newsItemService.deleteNewsItem(newsItemId);
    }

    @PutMapping("/{newsItemId}")
    public ResponseEntity<NewsItemResponseDto> updateNewsItem(@RequestBody @Valid NewsItemRequestDto newsItemRequestDto, @PathVariable Long newsItemId) {
        NewsItem newsItem = newsItemService.updateNewsItem(newsItemRequestDto, newsItemId);
        return ResponseEntity.ok(newsItemMapper.toNewsItemResponseDto(newsItem));
    }
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<NewsItem>> getNewsItemsByCategoryId(@PathVariable Long categoryId) {
        return ResponseEntity.ok(newsItemService.findNewsItemsByCategory(categoryId));
    }

}
