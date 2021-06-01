package com.airport.dao;

import com.airport.domain.Region;

import java.util.List;

/**
 * @author Sanyog Varshney
 * @since 1.0
 * @version 1.0
 */
public interface IRegionDAO extends IDAO<Region> {
    Region findByCode(String code);
    List<Region> findByContinent(String continent);
    List<Region> findByName(String name);
}
