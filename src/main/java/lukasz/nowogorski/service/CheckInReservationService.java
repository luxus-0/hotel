package lukasz.nowogorski.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
@Log4j2
public class CheckInReservationService {

    private final LocalTime earlyCheckIn = LocalTime.of(7,0);
    private final LocalTime lateCheckIn = LocalTime.of(22,0);
    private final LocalTime checkOut = LocalTime.of(11,0);
    private final LocalTime lateCheckOut = LocalTime.of(22,0);


    public List<LocalTime> allowCheckInTime()
    {

       long permit =  ChronoUnit.HOURS.between(earlyCheckIn,lateCheckIn) + 1;
       return Stream.iterate(earlyCheckIn,localTime -> localTime.plusHours(1))
               .limit(permit)
               .collect(Collectors.toList());

    }

    public List<LocalTime> allowCheckOutTime()
    {

        long permit =  ChronoUnit.HOURS.between(checkOut,lateCheckOut);
        return Stream.iterate(checkOut,localTime -> localTime.plusHours(1))
                .limit(permit)
                .collect(Collectors.toList());

    }
}
