package lukasz.nowogorski.flight.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lukasz.nowogorski.flight.model.Flight;
import lukasz.nowogorski.flight.repository.FlightRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class FlightDate {

    private final FlightRepository repository;

    public LocalDate getDepartureDate(LocalDate depart)
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

        return depart;
    }

    public LocalDate getReturnDate(LocalDate returnDate)
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

        return returnDate;
    }
}
