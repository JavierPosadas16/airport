package com.airport.ev.service;
import com.airport.ev.model.Country;
import com.airport.ev.model.Employee;

import java.util.List;


public interface CountryService {
	Country createCountry(Country country);
	Country updateCountry(Country country);
	List<Country> getAllCountry();
	Country getCountryById(long countryId);
	void deleteCountry(long id);
}
