package mk.ukim.finki.bookstoreproject.service;

import java.util.List;
import java.util.Optional;
import mk.ukim.finki.bookstoreproject.model.Book;
import mk.ukim.finki.bookstoreproject.model.dto.BookDto;

public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> save(BookDto bookDto);

    List<Book> searchBook(String query);

    Optional<Book> edit(Long id, BookDto bookDto);

    void deleteById(Long id);

    boolean markAsRented(Long id);
}
