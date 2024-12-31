package ecommercespringlabs.springbootlabslab4.service;

import ecommercespringlabs.springbootlabslab4.domain.NewsItem;
import ecommercespringlabs.springbootlabslab4.dto.news.NewsItemRequestDto;

import java.util.List;

public interface NewsItemService {
    List<NewsItem> findAllNewsItems();

    List<NewsItem> findAllNewsItemsByTitle(String title);

    NewsItem addNewsItem(NewsItemRequestDto newsItem);

    NewsItem updateNewsItem(NewsItemRequestDto newsItem, Long id);

    void deleteNewsItem(Long newsItemId);

    NewsItem findNewsItemById(Long id);

    List<NewsItem> findNewsItemsByCategory(Long categoryId);
}
