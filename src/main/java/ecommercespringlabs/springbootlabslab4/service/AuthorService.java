package ecommercespringlabs.springbootlabslab4.service;

import ecommercespringlabs.springbootlabslab4.domain.Author;
import ecommercespringlabs.springbootlabslab4.dto.author.AuthorRequestDto;

import java.util.List;

public interface AuthorService {
    List<Author> findAllAuthors();
    Author findAuthorById(Long id);
    Author addAuthor(AuthorRequestDto authorRequestDto);
    void deleteAuthor(Long id);
    Author updateAuthor(AuthorRequestDto authorRequestDto, Long id);
}
