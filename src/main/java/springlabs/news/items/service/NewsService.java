package springlabs.news.items.service;

import springlabs.news.items.News;

import java.util.List;

public interface NewsService {
    List<News> findAllItems();
    List<News> findItemByName(String title);
}
