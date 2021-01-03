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

    private List<String> detailFlight;
    public void getDetail(String info)
    {
            validDetailFlight(info);
            detailFlight.stream()
                    .filter(p -> p.length() > 0)
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
