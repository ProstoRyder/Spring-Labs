package springlabs.news.items.repository;

import springlabs.news.items.News;

import java.util.List;

public interface NewsRepository {
    List<News> findAllItems();
    List<News> findItemsByName(String title);
}
