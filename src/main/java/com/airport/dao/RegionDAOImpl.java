package com.airport.dao;

import com.airport.db.AirportsInMemoryDB;
import com.airport.domain.Region;
import com.airport.exception.ObjectNotFoundException;

import java.nio.file.ProviderNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Sanyog Varshney
 * @version 1.0
 * @since 1.0
 */
public class RegionDAOImpl implements IRegionDAO {

    @Override
    public List<Region> findAll() {
        return AirportsInMemoryDB.regions();
    }

    public Region findById(Long id) {
        return AirportsInMemoryDB.regions().stream().filter(r -> r.getId().equals(id)).findFirst().orElseThrow(ObjectNotFoundException::new);
    }

    @Override
    public Region findByCode(String code) {
        return AirportsInMemoryDB.regions().stream().filter(r -> r.getCode().equals(code)).findFirst().orElseThrow(ProviderNotFoundException::new);
    }

    @Override
    public List<Region> findByContinent(String continent) {
        return AirportsInMemoryDB.regions().stream().filter(r -> r.getContinent().equals(continent)).collect(Collectors.toList());
    }

    @Override
    public List<Region> findByName(String name) {
        return AirportsInMemoryDB.regions().stream().filter(r -> r.getName().contains(name)).collect(Collectors.toList());
    }
}
