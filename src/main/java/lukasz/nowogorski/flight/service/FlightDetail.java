package lukasz.nowogorski.flight.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lukasz.nowogorski.flight.model.Flight;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Log4j2
public class FlightDetail {

    private List<String> detailFlight;
    private final FlightDate date;
    private final FlightTime time;
    private final FlightCity city;
    private final FlightCreator flight;

    public void getDetail(String info)
    {
            validDetailFlight(info);
            detailFlight.stream()
                    .filter(p -> date != null && time != null && city != null)
                    .forEach(System.out::println);
    }

    public String validDetailFlight(String info)
    {
        this.detailFlight = List.of(info);
        return detailFlight.stream()
                .filter(Objects::isNull)
                .findAny()
                .orElseThrow();
    }
}
