package springlabs.news.items.service.impl;

import org.springframework.boot.context.properties.bind.Nested;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import springlabs.news.items.News;
import springlabs.news.items.repository.impl.NewsRepositoryImpl;
import springlabs.news.items.service.NewsService;

import java.util.List;

@Service
@Primary
public class FirstNewsService implements NewsService {
    private NewsRepositoryImpl newsRepository;

    public FirstNewsService(NewsRepositoryImpl newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public List<News> findAllItems() {
        return newsRepository.findAllItems();
    }

    @Override
    public List<News> findItemByName(String title) {
        return newsRepository.findItemsByName(title);
    }
}
