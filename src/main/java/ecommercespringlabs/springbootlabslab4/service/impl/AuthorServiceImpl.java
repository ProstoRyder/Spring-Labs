package ecommercespringlabs.springbootlabslab4.service.impl;

import ecommercespringlabs.springbootlabslab4.domain.Author;
import ecommercespringlabs.springbootlabslab4.dto.author.AuthorRequestDto;
import ecommercespringlabs.springbootlabslab4.mapper.AuthorMapper;
import ecommercespringlabs.springbootlabslab4.repository.AuthorRepository;
import ecommercespringlabs.springbootlabslab4.repository.entity.AuthorEntity;
import ecommercespringlabs.springbootlabslab4.service.AuthorService;
import ecommercespringlabs.springbootlabslab4.service.exception.AuthorNotFoundException;
import jakarta.persistence.PersistenceException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;
    private AuthorMapper authorMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Author> findAllAuthors() {
        return authorMapper.toAuthorList(authorRepository.findAll());
    }

    @Override
    public Author findAuthorById(Long id) {
        return authorMapper.toAuthor(authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException(id.toString())));
    }

    @Override
    public Author addAuthor(AuthorRequestDto authorRequestDto) {
        AuthorEntity authorEntity = AuthorEntity.builder()
                .name(authorRequestDto.getName())
                .phoneNumber(authorRequestDto.getPhoneNumber())
                .email(authorRequestDto.getEmail())
                .build();
        try {
            return authorMapper.toAuthor(authorRepository.save(authorEntity));
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    public void deleteAuthor(Long id) {
        findAuthorById(id);
        try {
            authorRepository.deleteById(id);
        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    public Author updateAuthor(AuthorRequestDto authorRequestDto, Long id) {
        AuthorEntity author = authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException(id.toString()));
        author.setName(authorRequestDto.getName());
        author.setPhoneNumber(authorRequestDto.getPhoneNumber());
        author.setEmail(authorRequestDto.getEmail());
        try {
            return authorMapper.toAuthor(authorRepository.save(author));
        } catch (Exception e) {
            throw new PersistenceException(e);
        }

    }
}
