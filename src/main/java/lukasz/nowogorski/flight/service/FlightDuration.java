package lukasz.nowogorski.flight.service;

import lombok.extern.log4j.Log4j2;
import lukasz.nowogorski.flight.exception.WrongTimeStartFlighException;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Service
@Log4j2
public class FlightDuration {

    public List<Duration> getFlightDuration(Integer hours) {
        List<Duration> durationFlights = List.of(Duration.ofHours(hours));
        for (Duration b : durationFlights) {
            if (b.isZero()) {
                throw new RuntimeException("Duration flight is 0 h");
            }
            else
            {
                durationFlights.stream().sorted()
                        .forEach(System.out::println);
            }
        }
        return durationFlights;
    }

    public List<LocalTime> delayFlight(LocalTime startFlight, LocalTime endFlight,long hour)
    {
        LocalTime delay = startFlight.plusHours(hour);
        if(startFlight.isAfter(endFlight))
        {
            Set.of(startFlight,endFlight).stream()
                    .filter(p -> startFlight.getHour() > 0 && endFlight.getHour() > 0)
                    .findAny()
                    .orElseThrow(() -> new WrongTimeStartFlighException("Start time flight is more than end time flight!!"));
        }
        else if(startFlight.isBefore(endFlight))
        {
            Set.of(startFlight,endFlight).stream()
                    .filter(p -> Duration.between(startFlight,endFlight).toHours() > 0)
                    .findAny()
                    .orElseThrow(() -> new WrongTimeStartFlighException("Start time flight is more than end time flight"));
        }
        else if(startFlight.equals(endFlight))
        {
            LocalTime localTime = Set.of(startFlight,endFlight).stream().findFirst()
                    .orElseThrow(() -> new RuntimeException("Start time flight is not equal end time flight"));

            log.info(localTime);
        }

        return List.of(delay);
    }
}
