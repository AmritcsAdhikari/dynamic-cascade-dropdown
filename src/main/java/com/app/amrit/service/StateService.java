package com.app.amrit.service;

import com.app.amrit.model.City;
import com.app.amrit.repo.StateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    public List<Object[]> getCitiesByState(Integer id){
        return stateRepository.getCitiesByState(id);
    }
}
