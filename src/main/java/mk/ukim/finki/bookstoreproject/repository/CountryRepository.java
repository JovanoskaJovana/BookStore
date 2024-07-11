package mk.ukim.finki.bookstoreproject.repository;

import mk.ukim.finki.bookstoreproject.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
