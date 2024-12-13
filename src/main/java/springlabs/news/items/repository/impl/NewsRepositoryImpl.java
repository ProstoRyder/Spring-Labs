package springlabs.news.items.repository.impl;


import org.springframework.stereotype.Repository;
import springlabs.news.items.News;
import springlabs.news.items.repository.NewsRepository;

import java.util.Arrays;
import java.util.List;

@Repository
public class NewsRepositoryImpl implements NewsRepository {
    private final List<News> news = Arrays.asList(
            new News("President", "New president","Політика","Taras"),
            new News("Sport","Sport","Спорт","Bolodja"),
            new News("Economy","Economy","Economy","Parik"),
            new News("Urgent News", "Breaking News", "Важлива", "Lena"),
            new News(null, "No title provided", "Unknown", "Anonymous"),
            new News("Sport", "Match Results", "Sport", null)

    );

    public List<News> findAllItems() {
        return news;
    }

    public List<News> findItemsByName(String title) {
        return news.stream().filter(news -> news.getTitle().equalsIgnoreCase(title)).toList();
    }
}
