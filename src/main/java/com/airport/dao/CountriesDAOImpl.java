package com.airport.dao;

import com.airport.db.AirportsInMemoryDB;
import com.airport.domain.Country;
import com.airport.exception.ObjectNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Sanyog Varshney
 * @version 1.0
 * @since 1.0
 */
public class CountriesDAOImpl implements ICountriesDAO {

    /**
     * @return List
     */
    @Override
    public List<Country> findAll() {
        return AirportsInMemoryDB.countries();
    }

    /**
     * @param id
     * @return Country
     */
    public Country findById(Long id) {
        return AirportsInMemoryDB.countries().stream().filter(c -> c.getId().equals(id)).findFirst().orElseThrow(ObjectNotFoundException::new);
    }

    /**
     * @param name
     * @return List
     */
    @Override
    public List<Country> findByName(String name) {
        return AirportsInMemoryDB.countries().stream().filter(c -> c.getName().contains(name)).collect(Collectors.toList());
    }


    /**
     * @param continent
     * @return List
     */
    @Override
    public List<Country> findByContinent(String continent) {
        return AirportsInMemoryDB.countries().stream().filter(c -> c.getContinent().contains(continent)).collect(Collectors.toList());
    }

    @Override
    public Country findByCode(String code) {
        return AirportsInMemoryDB.countries().stream().filter(r -> r.getCode().equals(code)).findFirst().orElseThrow(ObjectNotFoundException::new);
    }

}
