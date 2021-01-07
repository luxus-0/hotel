package lukasz.nowogorski.flight.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Log4j2
public class FlightDetail {

    private final FlightDate date;
    private final FlightTime time;
    private final FlightCity city;
    private final FlightDatabase database;

    public void getDetail(String info)
    {
            validDetailFlight(info);
            FlightCreator flight = new FlightCreator();
            flight.createDetailFlight(database.addFlight());

            List<String> detailFlight = List.of(info);
            detailFlight.stream()
                    .filter(p -> date != null && time != null && city != null)
                    .forEach(System.out::println);
    }

    public String validDetailFlight(String info)
    {
        List<String> detailFlight = List.of(info);
        return detailFlight.stream()
                .filter(Objects::isNull)
                .findAny()
                .orElseThrow();
    }
}
