package com.airport.ev.controller;
import com.airport.ev.exception.Mensaje;
import com.airport.ev.model.Country;
import com.airport.ev.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {
	@Autowired
	private CountryService countryService;

	//Lista todos las Ciudades
	@GetMapping("/listaCiudad")
	public ResponseEntity<?> getAllCountry() {
		List<Country> lista = countryService.getAllCountry();
		if(lista.isEmpty()){
			return new ResponseEntity<>(new Mensaje("Sin Info en la Base de Datos"), HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().body(countryService.getAllCountry());
	}
	//Lista Ciudad por Id
	@GetMapping("/ciudad/{id}")
	public ResponseEntity<Country> getCountryById(@PathVariable long id) {
		return ResponseEntity.ok().body(countryService.getCountryById(id));
	}

	//Actualiza Ciudad
	@PutMapping("/actualizarCiudad/{id}")
	public ResponseEntity<Country> updateCountry(@PathVariable long id, @RequestBody Country country) {
		country.setId(id);
		return ResponseEntity.ok().body(this.countryService.updateCountry(country));
	}

	//elimina Ciudad
	@DeleteMapping("/eliminaCiudad/{id}")
	public HttpStatus deleteCountry(@PathVariable long id) {
		this.countryService.deleteCountry(id);
		return HttpStatus.OK;
	}
}