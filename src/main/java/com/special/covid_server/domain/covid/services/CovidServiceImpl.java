package com.special.covid_server.domain.covid.services;

import com.special.covid_server.domain.core.ecveptions.ResourceCreationException;
import com.special.covid_server.domain.core.ecveptions.ResourceNotFoundException;
import com.special.covid_server.domain.covid.models.Covid;
import com.special.covid_server.domain.covid.models.CovidType;
import com.special.covid_server.domain.covid.repos.CovidRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CovidServiceImpl implements CovidService {
   private CovidRepo covidRepo;

   @Autowired
   public CovidServiceImpl(CovidRepo covidRepo){this.covidRepo = covidRepo; }


    @Override
    public Covid create(Covid covid) throws ResourceCreationException {
        Optional<Covid> optional = covidRepo.findByEmail(covid.getEmail());
        if(optional.isPresent())
            throw new ResourceCreationException("Covid file already exist");
        return covidRepo.save(covid);
    }

    @Override
    public Covid getById(Long id) throws ResourceNotFoundException {
       Covid covid = covidRepo.findById(id)
               .orElseThrow(()-> new ResourceNotFoundException("No Covid file with id: " +id));
        return covid;
    }

    @Override
    public Covid getByEmail(String email) throws ResourceNotFoundException {
       Covid covid = covidRepo.findByEmail(email)
               .orElseThrow(()-> new ResourceNotFoundException("No Covid  with email: " +email));
        return covid;
    }

    @Override
    public List<Covid> getByCovidType(CovidType covidType) throws ResourceNotFoundException {
       List<Covid> covid = covidRepo.findByCovidType(covidType);
        return covid;
    }

    @Override
    public List<Covid> getAll() {
        return (List<Covid>) covidRepo.findAll();
    }

    @Override
    public Covid update(Long id, Covid covidDetail) throws ResourceNotFoundException {
       Covid covid = getById(id);
       covid.setEmail(covidDetail.getEmail());
       covid.setCovidType(covidDetail.getCovidType());
       covid = covidRepo.save(covid);
        return covid;
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
       Covid covid = getById(id);
       covidRepo.delete(covid);

    }
}
