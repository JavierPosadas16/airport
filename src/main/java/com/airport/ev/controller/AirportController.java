package com.airport.ev.controller;

import com.airport.ev.exception.Mensaje;
import com.airport.ev.model.Airport;
import com.airport.ev.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airport")
public class AirportController {
	@Autowired
	private AirportService airportService;

	//Lista todos los Aereopuertos
	@GetMapping("/listaAereopuerto")
	public ResponseEntity<?> getAllAirport() {
		List<Airport> lista = airportService.getAllAirport();
		if(lista.isEmpty()){
			return new ResponseEntity<>(new Mensaje("Sin Info en la Base de Datos"), HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().body(airportService.getAllAirport());
	}
	//Lista Aereopuerto por Id
	@GetMapping("/aereopuerto/{id}")
	public ResponseEntity<Airport> getAirportById(@PathVariable long id) {
		return ResponseEntity.ok().body(airportService.getAirportById(id));
	}

	//Actualiza Aereopuerto
	@PutMapping("/actualizarAereopuerto/{id}")
	public ResponseEntity<Airport> updateAirport(@PathVariable long id, @RequestBody Airport airport) {
		airport.setId(id);
		return ResponseEntity.ok().body(this.airportService.updateAirport(airport));
	}

	//elimina Aereopuerto
	@DeleteMapping("/eliminaAereopuerto/{id}")
	public HttpStatus deleteAirport(@PathVariable long id) {
		this.airportService.deleteAirport(id);
		return HttpStatus.OK;
	}
}