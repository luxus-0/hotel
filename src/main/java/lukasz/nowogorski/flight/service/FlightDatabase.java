package lukasz.nowogorski.flight.service;

import lombok.RequiredArgsConstructor;
import lukasz.nowogorski.flight.model.Flight;
import lukasz.nowogorski.flight.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
@RequiredArgsConstructor
public class FlightDatabase {

    private final FlightRepository flightRepository;

    public Flight addFlight()
    {
        Flight flight = new Flight
                (
                      1L,"Warsaw","Cracow",
                        LocalDate.of(2020,12,1),
                        LocalDate.of(2020,12,12),
                        LocalTime.now(),LocalTime.now().plusHours(4)
                );

        flightRepository.save(flight);
        return flight;
    }
}
