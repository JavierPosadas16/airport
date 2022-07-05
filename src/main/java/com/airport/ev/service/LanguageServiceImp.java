package com.airport.ev.service;
import com.airport.ev.model.Language;
import com.airport.ev.repository.LenguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LanguageServiceImp implements LanguageService {

    @Autowired
    private LenguageRepository languageRepository;

    @Override
    public Language updateLanguage(Language language) {
        Optional<Language> LanguageT = this.languageRepository.findById(language.getId());

        if (LanguageT.isPresent()) {
            Language updateLanguage = LanguageT.get();
            updateLanguage.setId(language.getId());
            updateLanguage.setCode(language.getCode());
            updateLanguage.setName(language.getName());
            updateLanguage(updateLanguage);
            return updateLanguage;
        } else {
            try {
                throw new Exception("Empleado no econtrado con el id: " + language.getId());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public List<Language> getAllLanguage() {
        return this.languageRepository.findAll();
    }

    @Override
    public Language getLanguageById(long LanguageId) {
        Optional<Language> LanguageT = this.languageRepository.findById(LanguageId);

        if (LanguageT.isPresent()) {
            return LanguageT.get();
        } else {
            try {
                throw new Exception("Aereopuerto no econtrado con el id: " + LanguageId);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void deleteLanguage(long LanguageId) {
        Optional<Language> LanguageT = this.languageRepository.findById(LanguageId);

        if (LanguageT.isPresent()) {
            this.languageRepository.delete(LanguageT.get());
        } else {
            try {
                throw new Exception("Aereopuerto no econtrado con el id: " + LanguageId);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
