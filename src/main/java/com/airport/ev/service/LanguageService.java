package com.airport.ev.service;
import com.airport.ev.model.Airport;
import com.airport.ev.model.Language;
import java.util.List;


public interface LanguageService {

	Language createLanguage(Language language);
	Language updateLanguage(Language language);
	List<Language> getAllLanguage();
	Language getLanguageById(long languageId);
	void deleteLanguage(long id);
}
