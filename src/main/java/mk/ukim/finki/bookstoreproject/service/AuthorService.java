package mk.ukim.finki.bookstoreproject.service;

import java.util.List;
import java.util.Optional;
import mk.ukim.finki.bookstoreproject.model.Author;
import mk.ukim.finki.bookstoreproject.model.dto.AuthorDto;

public interface AuthorService {
    List<Author> findAll();

    Optional<Author> findById(Long id);

    Optional<Author> save(AuthorDto authorDto);

    Optional<Author> edit(Long id, AuthorDto authorDto);

    void deleteById(Long id);
}
