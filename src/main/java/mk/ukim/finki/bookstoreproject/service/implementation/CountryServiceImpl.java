package mk.ukim.finki.bookstoreproject.service.implementation;

import mk.ukim.finki.bookstoreproject.model.Country;
import mk.ukim.finki.bookstoreproject.model.dto.CountryDto;
import mk.ukim.finki.bookstoreproject.model.exceptions.CountryNotFoundException;
import mk.ukim.finki.bookstoreproject.repository.CountryRepository;
import mk.ukim.finki.bookstoreproject.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    @Override
    public List<Country> listAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Optional<Country> save(CountryDto countryDto) {
        Country country = new Country(countryDto.getName(), countryDto.getContinent());
        countryRepository.save(country);
        return Optional.of(country);
    }

    @Override
    public Optional<Country> edit(Long id, CountryDto countryDto) {
        Country country = countryRepository.findById(id).orElseThrow(() -> new CountryNotFoundException(id));

        country.setName(countryDto.getName());
        country.setContinent(countryDto.getContinent());

        countryRepository.save(country);
        return Optional.of(country);
    }

    @Override
    public void deleteById(Long id) {
        countryRepository.deleteById(id);
    }
}
