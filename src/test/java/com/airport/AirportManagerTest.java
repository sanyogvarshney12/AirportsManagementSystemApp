package com.airport;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


/**
 * @author Sanyog Varshney
 * @since 1.0
 * @version 1.0
 */
public class AirportManagerTest {

    List<String> mockAirports;
    List<String> emptyAirports;
    List<String> continentsList;


    @Before
    public void init(){
        System.out.println("Executing before test");
    }

    @After
    public void destroy(){
        System.out.println("Executing before test");
    }

    /**
     *
     * @throws IOException
     * @throws URISyntaxException
     * @throws InterruptedException
     */
    @Test
    public void testListAllAirports() throws IOException, URISyntaxException, InterruptedException {
        fail("Not Implemented");
    }


    @Test
    public void testFindAirportsByName() {
        fail("Not Implemented");
    }

    @Test
    public void testFindAirportsByCountry() {
        fail("Not Implemented");
    }

    @Test
    public void testFindAirportsByType(){
        fail("Not Implemented");
    }

    @Test
    public void testFindAirportsBySize() {
        fail("Not Yet Impemented");
    }

    @Test
    public void testFindAirportsByRunways() {
        fail("Not Yet Impemented");
    }

    @Test
    public void testFindHelipads() {
        fail("Not Implemented");
    }


    public void testFindHelipads_Exception() {
        fail("Not Implemented");
    }

    @Test
    public void testFindAirportsByContinent() {
        fail("Not Implemented");
    }

    public void testFindAirportsByContinent_Exception() {
        fail("Not Implemented");
    }

    @Test
    public void testListAllRegions() throws IOException {
        fail("Not Implemented");
    }


    @Test
    public void testListAllNavaids() throws IOException {
        fail("Not Implemented");
    }

    @Test
    public void testListAll() {
        fail("Not Yet Impemented");
    }

    @Test
    public void testGetRandomAirport() {
        fail("Not Yet Impemented");
    }

    @Test
    public void testListCountries() throws IOException {
        fail("Not Implemented");
    }


    @Test
    public void testListContinents() throws IOException {
        fail("Not Implemented");
    }

    @Test
    public void testLogin() {
        fail("Not Yet Impemented");
    }

    @Test
    public void testSignup() {
        fail("Not Yet Impemented");
    }

    public void testHelp(){
        fail("Not Yet Impemented");
    }

    public void listAirportsSorted(){
        fail("Not Yet Impemented");
    }

    public void listAirportsPaginated(){
        fail("Not Yet Impemented");
    }
}
