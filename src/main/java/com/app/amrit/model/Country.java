package com.app.amrit.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "country")
public class Country {

    @Id
    private Integer id;
    private String name;

    /*
     * This is going to create an extra column called 'country_id_fk' in State Table.
     * 'country_id_fk' is a Foreign Key in State Table.
     * By Default, in case of @OneToMany, JoinColumn will create an additional column in 'the Many' Side.
     * */
    @OneToMany
    @JoinColumn(name = "country_id_fk")
    private Set<State> states;
}