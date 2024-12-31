package ecommercespringlabs.springbootlabslab4.dto.news;

import ecommercespringlabs.springbootlabslab4.domain.Author;
import ecommercespringlabs.springbootlabslab4.domain.Category;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewsItemResponseDto {
    String id;
    String title;
    String description;
    Category category;
    Author author;
}
