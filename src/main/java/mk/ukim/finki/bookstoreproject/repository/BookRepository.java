package mk.ukim.finki.bookstoreproject.repository;

import mk.ukim.finki.bookstoreproject.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
