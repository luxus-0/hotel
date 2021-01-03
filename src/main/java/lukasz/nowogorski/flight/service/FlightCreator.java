package lukasz.nowogorski.flight.service;

import lukasz.nowogorski.flight.model.Flight;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class FlightCreator {

    public Flight createFromCityToCity(String from,String to)
    {
        return Flight.builder()
                .fromCity(from)
                .toCity(to)
                .build();
    }

    public Flight createTimeDeparture(LocalTime departure)
    {
        return Flight.builder()
                .departureTime(departure)
                .build();
    }
}
