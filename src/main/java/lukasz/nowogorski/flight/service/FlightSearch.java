package lukasz.nowogorski.flight.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lukasz.nowogorski.flight.exception.SearchFlighByCityNotFound;
import lukasz.nowogorski.flight.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

@Service
@Log4j2
@RequiredArgsConstructor
public class FlightSearch {

    private final FlightRepository flightRepository;

    public void getFlightSearch(String fromCity,String toCity) throws SearchFlighByCityNotFound {
        Map<String,String> fromAndToCities = new HashMap<>();
        if(fromCity == null && toCity == null)
        {
            throw new IllegalArgumentException("Error!!!Write from city and to city!!");
        }
        else
        {
            fromAndToCities.put(fromCity,toCity);
            for(Map.Entry<String, String> city : fromAndToCities.entrySet())
            {
                fromAndToCities
                        .keySet()
                        .stream()
                        .sorted()
                        .filter(p -> city.getKey().equals(fromCity))
                        .findAny()
                        .orElseGet(() -> String.valueOf(new SearchFlighByCityNotFound("Search flight by city not found!!")));

                fromAndToCities
                        .values()
                        .stream()
                        .sorted()
                        .filter(p -> city.getValue().equals(toCity))
                        .findAny()
                        .orElseThrow(() -> new SearchFlighByCityNotFound("Search flight by city not found!!"));

            }
        }
    }
}
