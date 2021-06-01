package com.airport.dao;

import com.airport.domain.Airport;

import java.util.List;

/**
 * @author Sanyog Varshney
 * @since 1.0
 * @version 1.0
 */
public interface IAirportsDAO extends IDAO<Airport> {
    List<Airport> findByName(String name);
    List<Airport> findByType(String name);
    List<Airport> findByCountry(String country);
}
