package mk.ukim.finki.bookstoreproject.service.implementation;

import mk.ukim.finki.bookstoreproject.model.Author;
import mk.ukim.finki.bookstoreproject.model.Country;
import mk.ukim.finki.bookstoreproject.model.dto.AuthorDto;
import mk.ukim.finki.bookstoreproject.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.bookstoreproject.model.exceptions.CountryNotFoundException;
import mk.ukim.finki.bookstoreproject.repository.AuthorRepository;
import mk.ukim.finki.bookstoreproject.repository.CountryRepository;
import mk.ukim.finki.bookstoreproject.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }


    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Optional<Author> save(AuthorDto authorDto) {
        Country country = countryRepository.findById(authorDto.getCountry()).orElseThrow(() -> new CountryNotFoundException(authorDto.getCountry()));
        Author author = new Author(authorDto.getName(), authorDto.getSurname(), country);
        authorRepository.save(author);
        return Optional.of(author);
    }

    @Override
    public Optional<Author> edit(Long id, AuthorDto authorDto) {
        Country country = countryRepository.findById(authorDto.getCountry()).orElseThrow(() -> new CountryNotFoundException(authorDto.getCountry()));
        Author author = authorRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException(id));

        author.setName(authorDto.getName());
        author.setSurname(authorDto.getSurname());
        author.setCountry(country);

        authorRepository.save(author);
        return Optional.of(author);
    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }
}
