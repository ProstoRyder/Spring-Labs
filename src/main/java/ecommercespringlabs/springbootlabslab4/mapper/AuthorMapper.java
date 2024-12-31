package ecommercespringlabs.springbootlabslab4.mapper;

import ecommercespringlabs.springbootlabslab4.domain.Author;
import ecommercespringlabs.springbootlabslab4.domain.Category;
import ecommercespringlabs.springbootlabslab4.dto.author.AuthorResponseDto;
import ecommercespringlabs.springbootlabslab4.repository.entity.AuthorEntity;
import ecommercespringlabs.springbootlabslab4.repository.entity.CategoryEntity;

import java.util.List;

public interface AuthorMapper {
    Author toAuthor(AuthorEntity authorEntity);
    AuthorResponseDto toAuthorResponseDto(Author author);
    List<Author> toAuthorList(List<AuthorEntity> authorEntities);
    List<AuthorResponseDto> toAuthorResponseDtoList(List<Author> cauthorList);
    Author toAuthorFromEntity(AuthorEntity authorEntity);
    AuthorEntity toAuthorEntity(Author author);
}

