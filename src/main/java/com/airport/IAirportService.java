package com.airport;

import com.airport.domain.Airport;
import com.airport.domain.Country;
import com.airport.domain.NavigationAid;
import com.airport.domain.Region;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * @author Sanyog Varshney
 * @since 1.0
 * @version 1.0
 */
public interface IAirportService {

    public List<Airport> listAllAirports();
    public List<Airport> findAirportByName(String name);
    public List<Airport> findAirportByCountry(String country);
    public List<Airport> findHelipads();
    public List<Airport> findAirportsByContinent(String continent);
    public List<String> listContinents();
    public List<Country> listCountries();
    public List<Region> listAllRegions();
    public List<NavigationAid> listNavaids();
    public Airport randomAirport();

}
