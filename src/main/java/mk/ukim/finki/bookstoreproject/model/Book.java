package mk.ukim.finki.bookstoreproject.model;

import jakarta.persistence.*;
import lombok.Data;
import mk.ukim.finki.bookstoreproject.model.enumerations.BookCategory;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated (EnumType.STRING)
    private BookCategory bookCategory;

    @ManyToOne
    private Author author;

    private Integer availableCopies;

    public Book() {
    }

    public Book(String name, BookCategory bookCategory, Author author, Integer availableCopies) {
        this.name = name;
        this.bookCategory = bookCategory;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
