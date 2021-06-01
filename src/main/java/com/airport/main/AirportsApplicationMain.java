package com.airport.main;

import com.airport.constants.AirportType;
import com.airport.db.AirportsInMemoryDB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AirportsApplicationMain {
    private static final Logger logger = LoggerFactory.getLogger(AirportsApplicationMain.class);

    public static void main(String[] args) {
        AirportsInMemoryDB.airports();
        if (logger.isInfoEnabled())
            logger.info(AirportType.SMALLAIRPORT.getValue());
    }
}
