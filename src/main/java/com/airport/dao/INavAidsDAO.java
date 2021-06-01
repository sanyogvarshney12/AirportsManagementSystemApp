package com.airport.dao;

import com.airport.domain.NavigationAid;

import java.util.List;

/**
 * @author Sanyog Varshney
 * @since 1.0
 * @version 1.0
 */
public interface INavAidsDAO extends IDAO<NavigationAid> {


    List<NavigationAid> findByName(String name);
}
