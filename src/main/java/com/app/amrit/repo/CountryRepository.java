package com.app.amrit.repo;

import com.app.amrit.model.Country;
import com.app.amrit.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

    @Query("SELECT c.id,c.name FROM Country c")
    List<Object[]> getAllCountries();

    @Query("SELECT s.id,s.name FROM Country c JOIN c.states AS s WHERE c.id=:id")
    List<Object[]> getStatesByCountry(Integer id);


}
