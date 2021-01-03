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

    public void departureTimePassenger(LocalTime reserve) {
        if(repository.findFlightByDepartureTime(reserve).isEmpty())
        {
            repository.save(creator.createTimeDeparture(reserve));
            log.info("Departure Time: " +reserve);
        }
        else {
            Set<LocalTime> timeDepart = Set.of(reserve);
            timeDepart.stream().filter(p -> p.getHour() > 0).findAny().orElseThrow(RuntimeException::new);
        }

    }

    public void returnTimePassenger(LocalTime reserve) {
        if(repository.findFlightByReturnTime(reserve).isEmpty())
        {
            repository.save(creator.createTimeReturn(reserve));
            log.info("Return Time: " +reserve);
        }
        else {
            Set<LocalTime> timeDepart = Set.of(LocalTime.now());
            timeDepart.stream().filter(p -> p.getHour() > 0).findAny().orElseThrow(RuntimeException::new);
        }

    }
}
