package lukasz.nowogorski.flight.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lukasz.nowogorski.flight.exception.AddFlighByCityNotFound;
import lukasz.nowogorski.flight.exception.SearchFlighByCityNotFound;
import lukasz.nowogorski.flight.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
@Log4j2
@RequiredArgsConstructor
public class FlightCity {

    private final FlightRepository repository;
    private final FlightCreator create;

    public void getFlight(String startCity,String endCity) throws SearchFlighByCityNotFound {
        Map<String,String> fromAndToCities = new HashMap<>();
        if(startCity == null && endCity == null)
        {
            throw new IllegalArgumentException("Error!!!Write from city and to city!!");
        }
        else
        {
            fromAndToCities.put(startCity,endCity);
            for(Map.Entry<String, String> city : fromAndToCities.entrySet())
            {
                fromAndToCities
                        .keySet()
                        .stream()
                        .sorted()
                        .filter(p -> city.getKey().equals(startCity))
                        .findAny()
                        .orElseGet(() -> String.valueOf(new SearchFlighByCityNotFound("Search flight by city not found!!")));

                fromAndToCities
                        .values()
                        .stream()
                        .sorted()
                        .filter(p -> city.getValue().equals(endCity))
                        .findAny()
                        .orElseThrow(() -> new SearchFlighByCityNotFound("Search flight by city not found!!"));
            }
        }
    }

    public Set<String> addFlightByCity(String start, String end)
    {
        if(repository.findFlightByFromCity(start) == null && repository.findFlightByToCity(end) == null)
        {
            throw new AddFlighByCityNotFound("Empty start and end city!!");
        }
        else
        {
            Set<String> from = Set.of(start);
            Set<String> to = Set.of(end);

                from.stream()
                        .sorted()
                        .filter(st -> st.length() > 0 && st.toLowerCase().contains(start))
                        .findAny()
                        .ifPresentOrElse(p -> log.info("Start city"),() -> log.info("Empty start city!"));

            to.stream()
                    .sorted()
                    .filter(st -> st.length() > 0)
                    .findAny()
                    .ifPresentOrElse(p -> log.info("end city"),() -> log.info("Empty end city!"));

            repository.save(create.createFromCityToCity(start,end));

        }
        return Set.of(start,end);
    }

    public boolean removeFlight(String start, String end)
    {
        if(start != null && end != null)
        {
            Map<String, String> fromCitiesToCities = Map.of(start, end);
            for(Map.Entry<String,String> entryCity : fromCitiesToCities.entrySet())
            {
                log.info("Start city: "+entryCity.getKey() +
                        "End city: " +entryCity.getValue());
            }

        }
        else if(start == null && end == null) {

            Map<String, String> citiesFrom = new HashMap<>();
            citiesFrom.put(start,end);
            citiesFrom.entrySet()
                    .stream()
                    .findAny()
                    .ifPresentOrElse(p ->
                            log.info("Delete city"),
                            () -> log.info("Don't delete city"));
            return true;
            }
        return false;
    }

}

