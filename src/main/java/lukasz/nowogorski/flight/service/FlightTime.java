package lukasz.nowogorski.flight.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lukasz.nowogorski.flight.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Log4j2
public class FlightTime {

    private final FlightRepository repository;
    private final FlightCreator creator;

    public Set<LocalTime> timeTravelPassenger(LocalTime fromTime, LocalTime toTime) {
        if( repository.findFlightByDepartureTime(fromTime).isEmpty() &&
            repository.findFlightByDepartureTime(toTime).isEmpty()
           )
        {
            repository.save(creator.createTimeFlight(fromTime,toTime));
            log.info("Departure Time: " +fromTime);
            log.info("Return Time: " +fromTime);
        }
        else
            {
                Set<LocalTime> timeDepart = Set.of(fromTime);
                Set<LocalTime> timeReturn = Set.of(toTime);
                timeDepart.stream()
                    .filter(p -> p.getHour() > 0)
                    .findAny()
                    .orElseThrow(RuntimeException::new);

                timeReturn.stream()
                    .filter(p -> p.getHour() > 0)
                    .findAny()
                    .orElseThrow(RuntimeException::new);
        }

    return Set.of(fromTime,toTime);
    }
}
