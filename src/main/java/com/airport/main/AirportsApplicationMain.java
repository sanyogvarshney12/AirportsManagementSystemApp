package com.airport.main;

import ch.qos.logback.classic.Logger;
import com.airport.constants.AirportType;
import com.airport.db.AirportsInMemoryDB;
import com.airport.logger.ApplicationLogger;
import org.slf4j.LoggerFactory;

public class AirportsApplicationMain {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(AirportsApplicationMain.class);
    public static void main(String[] args) {
        AirportsInMemoryDB.airports();
        if (logger.isInfoEnabled())
            logger.info(AirportType.SMALLAIRPORT.getValue());
    }
}
