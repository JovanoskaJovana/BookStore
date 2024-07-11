package mk.ukim.finki.bookstoreproject.listeners;

import mk.ukim.finki.bookstoreproject.model.events.BookChangedEvent;
import mk.ukim.finki.bookstoreproject.model.events.BookCreatedEvent;
import mk.ukim.finki.bookstoreproject.model.events.BookDeletedEvent;
import mk.ukim.finki.bookstoreproject.service.BookService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class BookEventHandlers {
    private final BookService bookService;


    public BookEventHandlers(BookService bookService) {
        this.bookService = bookService;
    }

    @EventListener
    public void onBookCreated (BookCreatedEvent event) {
        System.out.println("Book Created");
    }

    @EventListener
    public void onBookChanged (BookChangedEvent event) {
        System.out.println("Book Changed");
    }

    @EventListener
    public void onBookDeleted(BookDeletedEvent event) {
        System.out.println("Book deleted");
    }

}
