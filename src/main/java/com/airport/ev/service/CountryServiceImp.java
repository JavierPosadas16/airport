package com.airport.ev.service;
import com.airport.ev.model.Country;
import com.airport.ev.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CountryServiceImp implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Country updateCountry(Country country) {
        Optional<Country> CountryT = this.countryRepository.findById(country.getId());

        if (CountryT.isPresent()) {
            Country updateCountry = CountryT.get();
            updateCountry.setId(country.getId());
            updateCountry.setCode(country.getCode());
            updateCountry.setName(country.getName());
            updateCountry.setAirport(country.getAirport());
            updateCountry(updateCountry);
            return updateCountry;
        } else {
            try {
                throw new Exception("Aereopuerto no econtrado con el id: " + country.getId());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public List<Country> getAllCountry() {
        return this.countryRepository.findAll();
    }

    @Override
    public Country getCountryById(long CountryId) {
        Optional<Country> CountryT = this.countryRepository.findById(CountryId);

        if (CountryT.isPresent()) {
            return CountryT.get();
        } else {
            try {
                throw new Exception("Aereopuerto no econtrado con el id: " + CountryId);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void deleteCountry(long CountryId) {
        Optional<Country> CountryT = this.countryRepository.findById(CountryId);

        if (CountryT.isPresent()) {
            this.countryRepository.delete(CountryT.get());
        } else {
            try {
                throw new Exception("Aereopuerto no econtrado con el id: " + CountryId);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
