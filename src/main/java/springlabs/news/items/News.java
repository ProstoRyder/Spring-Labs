package springlabs.news.items;

import lombok.Data;

@Data
public class News {
    private final String title;
    private final String description;
    private final String category;
    private final String author;


//    public News(String title, String description, String category, String author) {
//        this.title = title;
//        this.description = description;
//        this.category = category;
//        this.author = author;
//    }

//    public String getDescription() {
//        return description;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public String getCategory() {
//        return category;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public void setCategory(String category) {
//        this.category = category;
//    }
}
