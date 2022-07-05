package com.airport.ev.controller;

import com.airport.ev.model.Employee;
import com.airport.ev.model.Language;
import com.airport.ev.service.EmployeeService;
import com.airport.ev.service.LanguageService;
import com.example.springboot.app.exception.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/language")
public class LanguageController {
	@Autowired
	private LanguageService languageService;

	//Lista todos los Lenguajes
	@GetMapping("/listaLenguaje")
	public ResponseEntity<?> getAllLanguage() {
		List<Language> lista = languageService.getAllLanguage();
		if(lista.isEmpty()){
			return new ResponseEntity<>(new Mensaje("Sin producos en la Base de Datos"), HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().body(languageService.getAllLanguage());
	}
	//Lista Lenguaje por Id
	@GetMapping("/lenguaje/{id}")
	public ResponseEntity<Language> getLanguageById(@PathVariable long id) {
		return ResponseEntity.ok().body(languageService.getLanguageById(id));
	}

	//Actualiza Lenguaje
	@PutMapping("/actualizarLenguaje/{id}")
	public ResponseEntity<Language> updateLanguage(@PathVariable long id, @RequestBody Language language) {
		language.setId(id);
		return ResponseEntity.ok().body(this.languageService.updateLanguage(language));
	}

	//elimina Lenguaje
	@DeleteMapping("/eliminaLenguaje/{id}")
	public HttpStatus deleteLanguage(@PathVariable long id) {
		this.languageService.deleteLanguage(id);
		return HttpStatus.OK;
	}
}