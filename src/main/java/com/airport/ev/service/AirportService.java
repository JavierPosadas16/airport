package com.airport.ev.service;
import com.airport.ev.model.Airport;
import java.util.List;

public interface AirportService {
	Airport updateAirport(Airport airport);
	List<Airport> getAllAirport();
	Airport getAirportById(long airportId);
	void deleteAirport(long id);
}
