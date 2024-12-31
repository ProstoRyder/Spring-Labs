package ecommercespringlabs.springbootlabslab4.domain;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class NewsItem{
    String id;
    String title;
    String description;
    Category category;
    Author author;
}
