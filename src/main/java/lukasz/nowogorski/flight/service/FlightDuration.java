package lukasz.nowogorski.flight.service;

import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

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
}
