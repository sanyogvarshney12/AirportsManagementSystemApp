package com.airport.dao;

import com.airport.domain.Country;

import java.util.List;

/**
 * @author Sanyog Varshney
 * @since 1.0
 * @version 1.0
 */
public interface ICountriesDAO extends IDAO<Country> {

    List<Country> findByName(String name);

    List<Country> findByContinent(String name);

    Country findByCode(String code);
}
