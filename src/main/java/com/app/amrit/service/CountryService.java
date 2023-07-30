package com.app.amrit.service;

import com.app.amrit.model.Country;
import com.app.amrit.model.State;
import com.app.amrit.repo.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Object[]> getAllCountries(){
        return countryRepository.getAllCountries();
    }

    public List<Object[]> getStatesByCountry(Integer id){
        return countryRepository.getStatesByCountry(id);
    }
}
