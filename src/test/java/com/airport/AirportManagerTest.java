package com.airport;

import com.airport.dao.IAirportsDAO;
import com.airport.dao.ICountriesDAO;
import com.airport.dao.INavAidsDAO;
import com.airport.dao.IRegionDAO;
import com.airport.domain.Airport;
import com.airport.exception.NoAirportsFoundForContinentException;
import com.airport.exception.NoHeliportFoundException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;


/**
 * @author Sanyog Varshney
 * @since 1.0
 * @version 1.0
 */
public class AirportManagerTest {

    private IAirportService service;
    private IAirportsDAO airportsDAO ;
    private IRegionDAO regionDAO;
    private INavAidsDAO navAidsDAO;
    private ICountriesDAO countriesDAO;


    @Before
    public void init(){
        System.out.println("Executing before test");
        airportsDAO = Mockito.mock(IAirportsDAO.class);
        regionDAO = Mockito.mock(IRegionDAO.class);
        countriesDAO = Mockito.mock(ICountriesDAO.class);
        navAidsDAO= Mockito.mock(INavAidsDAO.class);
        service = new AirportManagerImpl(airportsDAO,regionDAO,navAidsDAO,countriesDAO);
        List<Airport> list = Mockito.mock(ArrayList.class);
        Mockito.when(list.get(0)).thenReturn(new Airport());
    }

    @After
    public void destroy(){
        System.out.println("Executing before test");
    }


    @Test
    public void testListAllAirports() {
        assertTrue(service.listAllAirports().isEmpty());
    }

    @Test
    public void testFindAirportsByName() {
        assertTrue(service.findAirportByName("Shenyang Dongta Airport").isEmpty());
    }

    @Test
    public void testFindAirportsByCountry() {
        assertTrue(service.findAirportByCountry("US").isEmpty());
    }

    @Test(expected = NoHeliportFoundException.class)
    public void testFindHelipads() {
        assertTrue(service.findHelipads().isEmpty());
    }

    @Test
    public void testFindAirportsByContinent() {
        assertTrue(service.findAirportsByContinent("NA").isEmpty());
    }

    @Test
    public void testListAllRegions(){
        assertTrue(service.listAllRegions().isEmpty());
    }

    @Test
    public void testListAllNavaids() throws IOException {
        assertTrue(service.listNavaids().isEmpty());
    }

    @Test
    public void testGetRandomAirport() {
        assertNotNull(service.randomAirport());
    }

    @Test
    public void testListCountries(){
        assertTrue(service.listCountries().isEmpty());
    }

    @Test
    public void testListContinents() throws IOException {
        assertTrue(service.listContinents().isEmpty());
    }
}
