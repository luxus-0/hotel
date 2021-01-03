package lukasz.nowogorski.flight.service;

import lukasz.nowogorski.flight.model.Flight;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    public Flight createTimeFlight(LocalTime timeDeparture,LocalTime timeReturn)
    {
        return Flight.builder()
                .departureTime(timeDeparture)
                .returnTime(timeReturn)
                //.details()
                .build();
    }


    public Flight createDateFlight(LocalDate dateDeparture,LocalDate dateReturn) {
        return Flight.builder()
                .departureDate(dateDeparture)
                .returnDate(dateReturn)
                .build();
    }

}
