package springlabs.news.items.repository.impl;


import org.springframework.stereotype.Repository;
import springlabs.news.items.News;
import springlabs.news.items.repository.NewsRepository;

import java.util.Arrays;
import java.util.List;

@Repository
public class NewsRepositoryImpl implements NewsRepository {
    private final List<News> news = Arrays.asList(
            new News("President", "New president","Politics","Taras"),
            new News("Sport","Sport","Sport","Bolodja"),
            new News("Economy","Economy","Economy","Parik")
    );

    public List<News> findAllItems() {
        return news;
    }

    public List<News> findItemsByName(String title) {
        return news.stream().filter(news -> news.getTitle().equalsIgnoreCase(title)).toList();
    }
}
