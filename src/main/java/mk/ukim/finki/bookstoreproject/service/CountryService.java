package mk.ukim.finki.bookstoreproject.service;

import mk.ukim.finki.bookstoreproject.model.Country;
import mk.ukim.finki.bookstoreproject.model.dto.CountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> listAll();
    Optional<Country> findById(Long id);
    Optional<Country> save(CountryDto countryDto);
    Optional<Country> edit(Long id, CountryDto countryDto);

    void deleteById(Long id);
}
