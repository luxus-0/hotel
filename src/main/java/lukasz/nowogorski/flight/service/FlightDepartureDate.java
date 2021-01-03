package lukasz.nowogorski.flight.service;

import lombok.RequiredArgsConstructor;
import lukasz.nowogorski.flight.model.Flight;
import lukasz.nowogorski.flight.repository.FlightRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class FlightDepartureDate {

    private final FlightRepository repository;

    public void getDepartureDate(LocalDate depart)
    {
        if(repository.findFlightByDepartureDate(depart).isEmpty())
        {
            Set<LocalDate> departure = Set.of(depart);
            departure.forEach(System.out::println);
            repository.save(
                    Flight.builder()
                            .departureDate(depart)
                            .build()
            );
        }
    }

    public void getReturnDate(LocalDate returnDate)
    {
        if(repository.findFlightByReturnDate(returnDate).isEmpty())
        {
            Set<LocalDate> departure = Set.of(returnDate);
            departure.forEach(System.out::println);
            repository.save(
                    Flight.builder()
                            .departureDate(returnDate)
                            .build()
            );
        }
    }
}
