package com.app.amrit.controller;

import com.app.amrit.model.City;
import com.app.amrit.model.Country;
import com.app.amrit.model.State;
import com.app.amrit.repo.CountryRepository;
import com.app.amrit.service.CountryService;
import com.app.amrit.service.StateService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class DynamicDropDownController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private StateService stateService;

    @GetMapping("/ping")
    public ResponseEntity<String> pingPong(){
        return new ResponseEntity("pong", HttpStatus.OK);
    }

    @GetMapping("/getCountries")
    public ResponseEntity<?> getCountries() {
        String json = null;
        List<Object[]> list = countryService.getAllCountries();
        System.out.println("-----");
        System.out.println(list.toString());
        System.out.println("-----");
        try {
            json = new ObjectMapper().writeValueAsString(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(json, HttpStatus.OK);
    }

    @GetMapping("/getStates")
    public ResponseEntity<?> getStates(@RequestParam Integer countryId)
    {
        String json = null;
        List<Object[]> list = countryService.getStatesByCountry(countryId);
        try {
            json = new ObjectMapper().writeValueAsString(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(json, HttpStatus.OK);
    }

    @GetMapping("/getCities")
    public ResponseEntity<?> getCities(@RequestParam Integer stateId)
    {
        String json = null;
        List<Object[]> list = stateService.getCitiesByState(stateId);
        try {
            json = new ObjectMapper().writeValueAsString(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(json, HttpStatus.OK);
    }


}
