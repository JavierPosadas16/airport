package com.airport.ev.repository;
import com.airport.ev.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LenguageRepository extends JpaRepository<Language, Long> {

}