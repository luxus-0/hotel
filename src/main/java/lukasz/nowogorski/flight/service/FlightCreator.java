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
                .build();
    }


    public Flight createDateFlight(LocalDate dateDeparture,LocalDate dateReturn) {
        return Flight.builder()
                .departureDate(dateDeparture)
                .returnDate(dateReturn)
                .build();
    }

    public Flight createDetailFlight(Flight detail)
    {
        return Flight.builder()
                .idFlight(detail.getIdFlight())
                .departureDate(detail.getDepartureDate())
                .returnDate(detail.getReturnDate())
                .departureTime(detail.getDepartureTime())
                .returnTime(detail.getReturnTime())
                .fromCity(detail.getFromCity())
                .toCity(detail.getToCity())
                .build();
    }

}
