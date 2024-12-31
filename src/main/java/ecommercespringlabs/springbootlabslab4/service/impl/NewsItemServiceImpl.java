package ecommercespringlabs.springbootlabslab4.service.impl;

import ecommercespringlabs.springbootlabslab4.domain.Author;
import ecommercespringlabs.springbootlabslab4.domain.Category;
import ecommercespringlabs.springbootlabslab4.domain.NewsItem;
import ecommercespringlabs.springbootlabslab4.dto.news.NewsItemRequestDto;
import ecommercespringlabs.springbootlabslab4.mapper.AuthorMapper;
import ecommercespringlabs.springbootlabslab4.mapper.CategoryMapper;
import ecommercespringlabs.springbootlabslab4.mapper.NewsItemMapper;
import ecommercespringlabs.springbootlabslab4.repository.CategoryRepository;
import ecommercespringlabs.springbootlabslab4.repository.NewsRepository;
import ecommercespringlabs.springbootlabslab4.repository.entity.CategoryEntity;
import ecommercespringlabs.springbootlabslab4.repository.entity.NewsItemEntity;
import ecommercespringlabs.springbootlabslab4.service.AuthorService;
import ecommercespringlabs.springbootlabslab4.service.CategoryService;
import ecommercespringlabs.springbootlabslab4.service.NewsItemService;
import ecommercespringlabs.springbootlabslab4.service.exception.NewsItemNotFoundException;
import jakarta.persistence.PersistenceException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class NewsItemServiceImpl implements NewsItemService {
    private NewsRepository newsRepository;
    private NewsItemMapper newsItemMapper;
    private CategoryMapper categoryMapper;
    private AuthorMapper authorMapper;
    private CategoryService categoryService;
    private AuthorService authorService;

    @Override
    @Transactional(readOnly = true)
    public List<NewsItem> findAllNewsItems() {
        return newsItemMapper.toNewsItemList(newsRepository.findAll());
    }

    @Override
    public NewsItem findNewsItemById(Long id) {
        return newsItemMapper.toNewsItem(newsRepository.findById(id)
                .orElseThrow(() -> new NewsItemNotFoundException(id.toString())));
    }

    @Override
    public List<NewsItem> findNewsItemsByCategory(Long categoryId) {
        return newsItemMapper.toNewsItemList(newsRepository.findByCategoryId(categoryId));
    }


    @Override
    public List<NewsItem> findAllNewsItemsByTitle(String title) {
        return List.of();
    }

    @Override
    public NewsItem addNewsItem(NewsItemRequestDto newsItemRequestDto) {
        Category category = categoryService.findCategoryById(Long.valueOf(newsItemRequestDto.getCategory()));
        Author author = authorService.findAuthorById(Long.valueOf(newsItemRequestDto.getAuthor()));
        NewsItemEntity newsItemEntity = NewsItemEntity.builder()
                .title(newsItemRequestDto.getTitle())
                .description(newsItemRequestDto.getDescription())
                .category(categoryMapper.toCategoryEntity(category))
                .author(authorMapper.toAuthorEntity(author))
                .build();
        try {
            return newsItemMapper.toNewsItem(newsRepository.save(newsItemEntity));
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    public void deleteNewsItem(Long id) {
        findNewsItemById(id);
        try {
            newsRepository.deleteById(id);
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    public NewsItem updateNewsItem(NewsItemRequestDto newsItemRequestDto, Long id) {
        NewsItemEntity newsItem = newsRepository.findById(id).orElseThrow(() -> new NewsItemNotFoundException(id.toString()));
        Category category = categoryService.findCategoryById(Long.valueOf(newsItemRequestDto.getCategory()));
        Author author = authorService.findAuthorById(Long.valueOf(newsItemRequestDto.getAuthor()));
        newsItem.setTitle(newsItemRequestDto.getTitle());
        newsItem.setDescription(newsItemRequestDto.getDescription());
        newsItem.setCategory(categoryMapper.toCategoryEntity(category));
        newsItem.setAuthor(authorMapper.toAuthorEntity(author));
        try {
            return newsItemMapper.toNewsItem(newsRepository.save(newsItem));
        } catch (Exception e) {
            throw new PersistenceException(e);
        }

    }
}
