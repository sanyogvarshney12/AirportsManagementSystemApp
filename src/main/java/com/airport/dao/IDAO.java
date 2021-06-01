package com.airport.dao;

import java.util.List;

/**
 * @author Sanyog Varshney
 * @since 1.0
 * @version 1.0
 */
public interface IDAO<T> {
    List<T> findAll();

    T findById(Long id);
}

