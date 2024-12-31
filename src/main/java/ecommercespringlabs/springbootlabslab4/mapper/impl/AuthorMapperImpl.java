package ecommercespringlabs.springbootlabslab4.mapper.impl;

import ecommercespringlabs.springbootlabslab4.domain.Author;
import ecommercespringlabs.springbootlabslab4.dto.author.AuthorResponseDto;
import ecommercespringlabs.springbootlabslab4.mapper.AuthorMapper;
import ecommercespringlabs.springbootlabslab4.repository.entity.AuthorEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorMapperImpl implements AuthorMapper {
    @Override
    public Author toAuthor(AuthorEntity authorEntity) {
        return Author.builder()
                .id(authorEntity.getId().toString())
                .name(authorEntity.getName())
                .phoneNumber(authorEntity.getPhoneNumber())
                .email(authorEntity.getEmail())
                .build();
    }

    @Override
    public AuthorResponseDto toAuthorResponseDto(Author author) {
        return AuthorResponseDto.builder()
                .id(author.getId())
                .name(author.getName())
                .phoneNumber(author.getPhoneNumber())
                .email(author.getEmail())
                .build();
    }


    @Override
    public List<Author> toAuthorList(List<AuthorEntity> authorEntities) {
        return authorEntities.stream().map(this::toAuthor).toList();
    }

    @Override
    public List<AuthorResponseDto> toAuthorResponseDtoList(List<Author> authorList) {
        return authorList.stream().map(this::toAuthorResponseDto).toList();
    }
    @Override
    public Author toAuthorFromEntity(AuthorEntity authorEntity) {
        return Author.builder()
                .id(authorEntity.getId().toString())
                .name(authorEntity.getName())
                .phoneNumber(authorEntity.getPhoneNumber())
                .email(authorEntity.getEmail())
                .build();
    }

    @Override
    public AuthorEntity toAuthorEntity(Author author) {
        return AuthorEntity.builder()
                .id(Long.valueOf(author.getId()))
                .name(author.getName())
                .phoneNumber(author.getPhoneNumber())
                .email(author.getEmail())
                .build();
    }
}
