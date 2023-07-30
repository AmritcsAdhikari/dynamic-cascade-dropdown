package com.app.amrit.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;
import jakarta.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "state")
public class State {

    @Id
    private Integer id;
    private String name;
    /*
    * This is going to create an extra column called 'state_id_fk' in City Table.
    * 'state_id_fk' is a Foreign Key in City Table.
    * By Default,in case of @OneToMany, JoinColumn will create an additional column in 'the Many' Side.
    * */
    @OneToMany
    @JoinColumn(name = "state_id_fk")
    private Set<City> cities;
}
