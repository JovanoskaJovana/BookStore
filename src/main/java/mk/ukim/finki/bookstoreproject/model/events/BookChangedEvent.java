package mk.ukim.finki.bookstoreproject.model.events;

import lombok.Getter;
import mk.ukim.finki.bookstoreproject.model.Book;
import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;


@Getter
public class BookChangedEvent extends ApplicationEvent {

    private LocalDateTime when;
    public BookChangedEvent(Book source) {
        super(source);
        this.when = LocalDateTime.now();

    }

    public BookChangedEvent(Book source, LocalDateTime when) {
        super(source);
        this.when = when;
    }
}
