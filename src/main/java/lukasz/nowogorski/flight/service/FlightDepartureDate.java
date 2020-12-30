package lukasz.nowogorski.flight.service;

import lombok.RequiredArgsConstructor;
import lukasz.nowogorski.flight.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class FlightDepartureDate {

    private final FlightRepository repository;

    public void getDepartureDate(LocalDate departure)
    {
        repository.findFlightByDepartureDate(departure);
    }
}
