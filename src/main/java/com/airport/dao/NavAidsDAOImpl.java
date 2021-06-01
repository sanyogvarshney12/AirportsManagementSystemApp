package com.airport.dao;

import com.airport.db.AirportsInMemoryDB;
import com.airport.domain.NavigationAid;
import com.airport.exception.ObjectNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Sanyog Varshney
 * @version 1.0
 * @since 1.0
 */
public class NavAidsDAOImpl implements INavAidsDAO {

    /**
     *
     * @return
     */
    @Override
    public List<NavigationAid> findAll() {
        return AirportsInMemoryDB.navaids();
    }

    /**
     *
     * @param id
     * @return NavAid
     */
    public NavigationAid findById(Long id) {
        return AirportsInMemoryDB.navaids().stream().filter(n -> n.getId().equals(id)).findFirst().orElseThrow(ObjectNotFoundException::new);
    }

    /**
     *
     * @param name
     * @return List
     */
    @Override
    public List<NavigationAid> findByName(String name) {
        return AirportsInMemoryDB.navaids().stream().filter(n -> n.getName().contains(name)).collect(Collectors.toList());
    }
}
