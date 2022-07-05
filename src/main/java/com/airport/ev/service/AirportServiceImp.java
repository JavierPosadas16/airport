package com.airport.ev.service;
import com.airport.ev.model.Airport;
import com.airport.ev.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AirportServiceImp implements AirportService {

    @Autowired
    private AirportRepository airportRepository;

    @Override
    public Airport updateAirport(Airport airport) {
        Optional<Airport> AirportT = this.airportRepository.findById(airport.getId());

        if (AirportT.isPresent()) {
            Airport updateAirport = AirportT.get();
            updateAirport.setId(airport.getId());
            updateAirport.setname(airport.getname());
            updateAirport(updateAirport);
            return updateAirport;
        } else {
            try {
                throw new Exception("Aereopuerto no econtrado con el id: " + airport.getId());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public List<Airport> getAllAirport() {
        return this.airportRepository.findAll();
    }

    @Override
    public Airport getAirportById(long AirportId) {
        Optional<Airport> AirportT = this.airportRepository.findById(AirportId);

        if (AirportT.isPresent()) {
            return AirportT.get();
        } else {
            try {
                throw new Exception("Aereopuerto no econtrado con el id: " + AirportId);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void deleteAirport(long AirportId) {
        Optional<Airport> AirportT = this.airportRepository.findById(AirportId);

        if (AirportT.isPresent()) {
            this.airportRepository.delete(AirportT.get());
        } else {
            try {
                throw new Exception("Aereopuerto no econtrado con el id: " + AirportId);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
