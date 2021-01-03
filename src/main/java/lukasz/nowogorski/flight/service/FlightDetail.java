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


    public void getDetail(String info)
    {
        List<String> detailFlight = List.of(info);

            detailFlight.stream()
                    .filter(Objects::isNull)
                    .findAny()
                    .orElseThrow();
        }
    }
