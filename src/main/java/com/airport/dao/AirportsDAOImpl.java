package com.airport.dao;

import com.airport.db.AirportsInMemoryDB;
import com.airport.domain.Airport;
import com.airport.exception.ObjectNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Sanyog Varshney
 * @version 1.0
 * @since 1.0
 */
public class AirportsDAOImpl implements IAirportsDAO {


    /**
     * @param name AirportName
     * @return
     */
    @Override
    public List<Airport> findByName(String name) {
        if(name ==null)
            throw new IllegalArgumentException();
        return AirportsInMemoryDB.airports().stream().filter(r -> r.getName().contains(name)).collect(Collectors.toList());
    }

    /**
     * @param type
     * @return
     */
    @Override
    public List<Airport> findByType(String type) {
        if (type == null)
            throw new IllegalArgumentException();
        return AirportsInMemoryDB.airports().stream().filter(r -> r.getType().equals(type)).collect(Collectors.toList());
    }


    /**
     * @param country
     * @return
     */
    @Override
    public List<Airport> findByCountry(String country) {
        if (country == null)
            throw new IllegalArgumentException();
        return AirportsInMemoryDB.airports().stream().filter(r -> r.getCountryName().equals(country)).collect(Collectors.toList());
    }

    /**
     * @return
     */
    @Override
    public List<Airport> findAll() {
        return AirportsInMemoryDB.airports();
    }

    /**
     * @param id
     * @return
     */
    public Airport findById(Long id) {
        if (id == null)
            throw new IllegalArgumentException();
        return AirportsInMemoryDB.airports().stream().filter(r -> r.getId().equals(id)).findFirst().orElseThrow(ObjectNotFoundException::new);
    }
}
