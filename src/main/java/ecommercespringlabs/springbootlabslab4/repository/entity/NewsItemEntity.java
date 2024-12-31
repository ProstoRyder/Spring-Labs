package ecommercespringlabs.springbootlabslab4.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "news")
@Builder(toBuilder = true)
public class NewsItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_product_seq")
    @SequenceGenerator(name = "id_news_seq", sequenceName = "id_product_seq")
    Long id;

    @Column(name = "title")
    String title;

    @Column(name = "description")
    String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "id_category")
    CategoryEntity category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name = "id_author")
    AuthorEntity author;
}
