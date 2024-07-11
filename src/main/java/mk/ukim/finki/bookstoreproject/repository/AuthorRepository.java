package mk.ukim.finki.bookstoreproject.repository;

import mk.ukim.finki.bookstoreproject.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
