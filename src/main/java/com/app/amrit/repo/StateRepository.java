package com.app.amrit.repo;

import com.app.amrit.model.City;
import com.app.amrit.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StateRepository  extends JpaRepository<State, Integer> {

    @Query("SELECT c.id,c.name FROM State s JOIN s.cities AS c WHERE s.id=:id")
    List<Object[]> getCitiesByState(Integer id);
}
