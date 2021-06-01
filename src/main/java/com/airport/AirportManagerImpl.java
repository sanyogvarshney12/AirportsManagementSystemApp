package com.airport;



import com.airport.logger.ApplicationLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;


/**
 * @author Sanyog Varshney
 * @since 1.0
 * @version 1.0
 */
public class AirportManagerImpl implements IAirportService{

    private static final String CLASSNAME = AirportManagerImpl.class.getName();
    private static final Logger log = LoggerFactory.getLogger(AirportManagerImpl.class);
    private final ApplicationLogger logger = new ApplicationLogger();
    private static final String METHODSTARTMSG = "***** Method Started *****";
    private static final String METHODENDMSG = "***** Method Ended *****";


    @Override
    public int listAllAirports() throws IOException, URISyntaxException, InterruptedException {
        return 0;
    }

    @Override
    public String findAirportByName(String name, List<String> airports) {
        return null;
    }

    @Override
    public List<String> findAirportByCountry(String country, List<String> airports) {
        return null;
    }

    @Override
    public List<String> findAirportByType(String type, List<String> airports) {
        return null;
    }

    @Override
    public long findHelipads(List<String> airports) {
        return 0;
    }

    @Override
    public List<String> findAirportsByContinent(String continent, List<String> airports) {
        return null;
    }

    @Override
    public List<String> listContinents() throws IOException {
        return null;
    }

    @Override
    public List<String> listCountries() throws IOException {
        return null;
    }

    @Override
    public List<String> listAllRegions() throws IOException {
        return null;
    }

    @Override
    public List<String> listNavaids() throws IOException {
        return null;
    }

    @Override
    public String randomAirport(List<String> airports) {
        return null;
    }
}
