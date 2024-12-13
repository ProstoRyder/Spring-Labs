package springlabs.news.items.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springlabs.news.items.News;
import springlabs.news.items.repository.NewsRepository;
import springlabs.news.items.repository.impl.NewsRepositoryImpl;
import springlabs.news.items.service.NewsService;

import java.util.List;

@Service
public class ThirdNewsService implements NewsService {
    private NewsRepository newsRepository;

    @Autowired
    public void setItemRepository(NewsRepositoryImpl newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public List<News> findAllItems() {
        return newsRepository.findAllItems();
    }

    @Override
    public List<News> findItemByName(String name) {
        return newsRepository.findItemsByName(name);
    }
}
