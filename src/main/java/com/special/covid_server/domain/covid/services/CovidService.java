package com.special.covid_server.domain.covid.services;

import com.special.covid_server.domain.core.ecveptions.ResourceCreationException;
import com.special.covid_server.domain.core.ecveptions.ResourceNotFoundException;
import com.special.covid_server.domain.covid.models.Covid;
import com.special.covid_server.domain.covid.models.CovidType;

import java.util.List;

public interface CovidService {
    Covid create(Covid covid) throws ResourceCreationException;
    Covid getById(Long id) throws ResourceNotFoundException;
    Covid getByEmail(String email) throws ResourceNotFoundException;
    List<Covid>getByCovidType(CovidType covidType) throws ResourceNotFoundException;
    List<Covid>getAll();
    Covid update(Long id,Covid covidDetail) throws ResourceNotFoundException;
    void delete (Long id) throws ResourceNotFoundException;


}
