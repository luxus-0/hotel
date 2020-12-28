package lukasz.nowogorski.flight.service;

import lukasz.nowogorski.flight.exception.WrongTimeStartFlighException;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Service
public class FlightDuration {

    public List<Duration> getFlightDuration(Integer hours) {
        List<Duration> durationFlights = List.of(Duration.ofHours(hours));
        for (Duration b : durationFlights) {
            if (b.isZero()) {
                throw new RuntimeException("Duration is 0 h");
            }
        }
        return durationFlights;
    }

    public void delayFlight(LocalTime startFlight,LocalTime endFlight)
    {
        if(startFlight.isAfter(endFlight))
        {
            Set.of(startFlight).stream()
                    .filter(p -> startFlight.getHour() > 0 && endFlight.getHour() > 0)
                    .findAny()
                    .orElseThrow(() -> new WrongTimeStartFlighException("Start time flight is more than end time flight"));
        }
    }
}
