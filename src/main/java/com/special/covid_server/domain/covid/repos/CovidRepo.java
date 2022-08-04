package com.special.covid_server.domain.covid.repos;

import com.special.covid_server.domain.covid.models.Covid;
import com.special.covid_server.domain.covid.models.CovidType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CovidRepo extends JpaRepository<Covid,Long> {
    Optional<Covid> findByEmail(String email);
    List<Covid> findByCovidType(CovidType covidType);
}
