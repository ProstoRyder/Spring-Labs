package ecommercespringlabs.springbootlabslab4.web;

import ecommercespringlabs.springbootlabslab4.domain.Author;
import ecommercespringlabs.springbootlabslab4.dto.author.AuthorRequestDto;
import ecommercespringlabs.springbootlabslab4.dto.author.AuthorResponseDto;
import ecommercespringlabs.springbootlabslab4.mapper.AuthorMapper;
import ecommercespringlabs.springbootlabslab4.service.AuthorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
@AllArgsConstructor
@Validated
public class AuthorController {
    private AuthorService authorService;
    private AuthorMapper authorMapper;

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponseDto> getAuthorById(@PathVariable Long id) {
        return ResponseEntity.ok(authorMapper.toAuthorResponseDto(authorService.findAuthorById(id)));
    }

    @GetMapping
    public ResponseEntity<List<AuthorResponseDto>> getAllAuthors() {
        return ResponseEntity.ok(authorMapper.toAuthorResponseDtoList(authorService.findAllAuthors()));
    }

    @PostMapping
    public ResponseEntity<AuthorResponseDto> addAuthor(@RequestBody @Valid AuthorRequestDto authorRequestDto) {
        return ResponseEntity.ok(authorMapper.toAuthorResponseDto(authorService.addAuthor(authorRequestDto)));
    }

    @DeleteMapping("/{authorId}")
    public void deleteAuthor(@PathVariable Long authorId) {
        authorService.deleteAuthor(authorId);
    }

    @PutMapping("/{authorId}")
    public ResponseEntity<AuthorResponseDto> updateAuthor(@RequestBody @Valid AuthorRequestDto authorRequestDto, @PathVariable Long authorId) {
        Author author = authorService.updateAuthor(authorRequestDto, authorId);
        return ResponseEntity.ok(authorMapper.toAuthorResponseDto(author));
    }
}
