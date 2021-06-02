package com.airport;

import com.airport.dao.IAirportsDAO;
import com.airport.dao.ICountriesDAO;
import com.airport.dao.INavAidsDAO;
import com.airport.dao.IRegionDAO;
import com.airport.domain.Airport;
import com.airport.domain.Country;
import com.airport.domain.NavigationAid;
import com.airport.domain.Region;
import com.airport.functions.FilterFunctions;
import com.airport.logger.ApplicationLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author Sanyog Varshney
 * @since 1.0
 * @version 1.0
 */
public class AirportManagerImpl implements IAirportService{

    private static final String CLASSNAME = AirportManagerImpl.class.getName();
    private static final Logger log = LoggerFactory.getLogger(AirportManagerImpl.class);
    private static final ApplicationLogger logger = new ApplicationLogger();
    private static final String METHODSTARTMSG = "***** Method Started *****";
    private static final String METHODENDMSG = "***** Method Ended *****";
    private static Random random;

    private IAirportsDAO airportsDAO;
    private IRegionDAO regionDAO;
    private INavAidsDAO navAidsDAO;
    private ICountriesDAO countriesDAO;

    static {
        try {
            random = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            logger.error("No Algorithm for Random found",e);
        }
    }

    public AirportManagerImpl(IAirportsDAO airportsDAO, IRegionDAO regionDAO, INavAidsDAO navAidsDAO, ICountriesDAO countriesDAO) {
        this.airportsDAO = airportsDAO;
        this.regionDAO = regionDAO;
        this.navAidsDAO = navAidsDAO;
        this.countriesDAO = countriesDAO;

    }
    /**
     *
     * @return List<Airport>
     */
    public List<Airport> listAllAirports() {
        String methodName = "listAllAirports()";
        log.debug(CLASSNAME, methodName, METHODSTARTMSG);
        logger.debug(CLASSNAME, methodName, "For people who fly: {} and counting...", airportsDAO.findAll().size());
        logger.debug(CLASSNAME, methodName, METHODENDMSG);
        return airportsDAO.findAll();
    }

    /**
     *
     * @param name
     * @return String
     */
    public List<Airport> findAirportByName(String name) {
        String methodName = "findAirportByName()";
        logger.debug(CLASSNAME, methodName, METHODSTARTMSG);
        List<Airport> airportByName = airportsDAO.findByName(name);
        logger.debug(CLASSNAME, methodName, METHODENDMSG);
        return airportByName;
    }

    /**
     *
     * @param country
     * @return List
     */
    public List<Airport> findAirportByCountry(String country) {
        String methodName = "findAirportByCountry()";
        logger.debug(CLASSNAME, methodName, METHODSTARTMSG);
        return airportsDAO.findByCountry(country);
    }


    /**
     * @return List<Airport>
     */
    public List<Airport> findHelipads() {
        String methodName = "findHelipads()";
        logger.debug(CLASSNAME, methodName, METHODSTARTMSG);
        List<Airport> helipadsList = airportsDAO.findByType("heliport");
        logger.debug(CLASSNAME, methodName, METHODENDMSG);
        return helipadsList;
    }

    /**
     *
     * @param continent
     * @return List
     */
    public List<Airport> findAirportsByContinent(String continent) {
        String methodName = "findAirportsByContinent()";
        logger.debug(CLASSNAME, methodName, METHODSTARTMSG);
        List<Country> countryList = countriesDAO.findByContinent(continent);
        List<Airport> airportByContinent = new ArrayList<>();
        countryList.stream().map(s-> airportByContinent.addAll(
            airportsDAO.findByCountry(s.getCode()))).collect(Collectors.toList());
        logger.debug(CLASSNAME, methodName, METHODENDMSG);
        return airportByContinent;
    }

    /**
     *
     * @return List
     * @throws IOException
     */
    @Override
    public List<String> listContinents(){
        String methodName = "listContinents()";
        logger.debug(CLASSNAME, methodName, METHODSTARTMSG);
        List<Country> countriesList = countriesDAO.findAll().stream().filter(FilterFunctions
                .distinctByKey(s->s.getContinent())).collect(Collectors.toList());
        List<String> continentList = countriesList.stream().map(s->s.getContinent())
                .collect(Collectors.toList());
        logger.debug(CLASSNAME, methodName, METHODENDMSG);
        return continentList;
    }

    /**
     *
     * @return List
     */
    @Override
    public List<Country> listCountries() {
        String methodName = "listCountries()";
        logger.debug(CLASSNAME, methodName, METHODSTARTMSG);
        return countriesDAO.findAll();
    }

    /**
     *
     * @return List
     */
    public List<Region> listAllRegions() {
        String methodName = "listAllRegions()";
        logger.debug(CLASSNAME, methodName, METHODSTARTMSG);
        return regionDAO.findAll();
    }

    /**
     *
     * @return List
     */
    @Override
    public List<NavigationAid> listNavaids() {
        String methodName = "listNavaids()";
        logger.debug(CLASSNAME, methodName, METHODSTARTMSG);
        return navAidsDAO.findAll();
    }

    @Override
    public Airport randomAirport() {
        List<Airport> list = airportsDAO.findAll();
        return list.size() !=0 ? list.get(random.nextInt(list.size())) : new Airport();
    }
}