package ecommercespringlabs.springbootlabslab4.mapper.impl;

import ecommercespringlabs.springbootlabslab4.domain.NewsItem;
import ecommercespringlabs.springbootlabslab4.dto.news.NewsItemResponseDto;
import ecommercespringlabs.springbootlabslab4.mapper.AuthorMapper;
import ecommercespringlabs.springbootlabslab4.mapper.CategoryMapper;
import ecommercespringlabs.springbootlabslab4.mapper.NewsItemMapper;
import ecommercespringlabs.springbootlabslab4.repository.entity.NewsItemEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class NewsItemMapperImpl implements NewsItemMapper {
    private final AuthorMapper authorMapper;
    private final CategoryMapper categoryMapper;

    @Override
    public NewsItem toNewsItem(NewsItemEntity newsItemEntity) {
        return NewsItem.builder()
                .id(newsItemEntity.getId().toString())
                .title(newsItemEntity.getTitle())
                .description(newsItemEntity.getDescription())
                .category(categoryMapper.toCategory(newsItemEntity.getCategory()))
                .author(authorMapper.toAuthor(newsItemEntity.getAuthor()))
                .build();
    }


    @Override
    public NewsItemResponseDto toNewsItemResponseDto(NewsItem newsItem) {
        return NewsItemResponseDto.builder()
                .id(newsItem.getId())
                .title(newsItem.getTitle())
                .description(newsItem.getDescription())
                .category(newsItem.getCategory())
                .author(newsItem.getAuthor())
                .build();
    }

    @Override
    public List<NewsItem> toNewsItemList(List<NewsItemEntity> newsItemEntities) {
        return newsItemEntities.stream().map(this::toNewsItem).toList();
    }

    @Override
    public List<NewsItemResponseDto> toNewsItemResponseDtoList(List<NewsItem> newsItemList) {
        return newsItemList.stream().map(this::toNewsItemResponseDto).toList();
    }
}
