package springlabs.news.items.service.impl;

import org.springframework.stereotype.Service;
import springlabs.news.items.News;

import springlabs.news.items.repository.impl.NewsRepositoryImpl;
import springlabs.news.items.service.NewsService;

import java.util.List;
@Service
public class SecondNewsService implements NewsService {

    private NewsRepositoryImpl newsRepository;

    @Override
    public List<News> findAllItems() {
        return newsRepository.findAllItems();
    }

    @Override
    public List<News> findItemByName(String title) {
        return newsRepository.findItemsByName(title);
    }
}
