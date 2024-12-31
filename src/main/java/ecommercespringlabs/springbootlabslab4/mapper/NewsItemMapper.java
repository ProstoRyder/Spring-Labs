package ecommercespringlabs.springbootlabslab4.mapper;

import ecommercespringlabs.springbootlabslab4.domain.NewsItem;
import ecommercespringlabs.springbootlabslab4.dto.news.NewsItemResponseDto;
import ecommercespringlabs.springbootlabslab4.repository.entity.NewsItemEntity;

import java.util.List;

public interface NewsItemMapper {
    NewsItem toNewsItem(NewsItemEntity newsItemEntity);
    NewsItemResponseDto toNewsItemResponseDto(NewsItem newsItem);
    List<NewsItem> toNewsItemList(List<NewsItemEntity> newsItemEntities);
    List<NewsItemResponseDto> toNewsItemResponseDtoList(List<NewsItem> newsItemList);
}
