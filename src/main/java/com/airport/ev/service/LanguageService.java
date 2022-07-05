package com.airport.ev.service;
import com.airport.ev.model.Language;
import java.util.List;


public interface LanguageService {
	Language updateLanguage(Language language);
	List<Language> getAllLanguage();
	Language getLanguageById(long languageId);
	void deleteLanguage(long id);
}
