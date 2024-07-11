package mk.ukim.finki.bookstoreproject.service.implementation;

import mk.ukim.finki.bookstoreproject.model.Author;
import mk.ukim.finki.bookstoreproject.model.Book;
import mk.ukim.finki.bookstoreproject.model.dto.BookDto;
import mk.ukim.finki.bookstoreproject.model.events.BookChangedEvent;
import mk.ukim.finki.bookstoreproject.model.events.BookCreatedEvent;
import mk.ukim.finki.bookstoreproject.model.events.BookDeletedEvent;
import mk.ukim.finki.bookstoreproject.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.bookstoreproject.model.exceptions.BookNotFoundException;
import mk.ukim.finki.bookstoreproject.service.BookService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import mk.ukim.finki.bookstoreproject.repository.BookRepository;
import mk.ukim.finki.bookstoreproject.repository.AuthorRepository;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private  final AuthorRepository authorRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        System.out.println(bookDto);
        Author author = authorRepository.findById(bookDto.getAuthorId()).orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthorId()));
        Book book = new Book(bookDto.getName(), bookDto.getBookCategory(), author, bookDto.getAvailableCopies());
        bookRepository.save(book);
        applicationEventPublisher.publishEvent(new BookCreatedEvent(book));
        return Optional.of(book);
    }

    @Override
    public List<Book> searchBook(String query) {
        return bookRepository.findByNameContainingIgnoreCase(query);
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Author author = authorRepository.findById(bookDto.getAuthorId()).orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthorId()));
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));

        book.setName(bookDto.getName());
        book.setBookCategory(bookDto.getBookCategory());
        book.setAuthor(author);
        book.setAvailableCopies(bookDto.getAvailableCopies());

        bookRepository.save(book);
        applicationEventPublisher.publishEvent(new BookChangedEvent(book));
        return Optional.of(book);
    }

    @Override
    public void deleteById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        bookRepository.deleteById(id);
        applicationEventPublisher.publishEvent(new BookDeletedEvent(book));
    }

    @Override
    public boolean markAsRented(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        int copies = book.getAvailableCopies();

        if (copies > 0) {
            book.setAvailableCopies(book.getAvailableCopies() - 1);
            bookRepository.save(book);
            return  true;
        }
        return false;
    }
}
