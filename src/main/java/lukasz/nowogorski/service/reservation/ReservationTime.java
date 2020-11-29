package lukasz.nowogorski.service.reservation;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lukasz.nowogorski.service.validation.ValidCheckInTime;
import lukasz.nowogorski.service.validation.ValidCheckOutTime;
import lukasz.nowogorski.service.validation.ValidEarlyCheckInTime;
import lukasz.nowogorski.service.validation.ValidLateCheckOutTime;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Log4j2
public class ReservationTime {

    private final ValidCheckInTime validCheckInTime;
    private final ValidCheckOutTime validCheckOutTime;
    private final ValidEarlyCheckInTime validEarlyCheckInTime;
    private final ValidLateCheckOutTime validLateCheckOutTime;

    public Set<LocalTime> getEarlyCheckInTime(LocalTime earlyCheckIn)
    {
        return List.of(earlyCheckIn)
                .stream()
                .filter(p -> ChronoUnit.HOURS.between(LocalTime.of(1,0),LocalTime.of(7,0))!= 0)
                .map(p->
                {
                    validEarlyCheckInTime.validate(earlyCheckIn);
                    return earlyCheckIn;
                })
               .collect(Collectors.toSet());
    }

    public List<LocalTime> getCheckInTime(LocalTime checkIn)
    {
        return List.of(checkIn)
                .stream()
                .filter(check -> check.equals(LocalTime.now()))
                .map(check ->
                {
                    validCheckInTime.validate(checkIn);
                    return checkIn;
                })
                .collect(Collectors.toList());
    }

    public Set<LocalTime> getCheckOutTime(LocalTime checkOut)
    {
        Set<LocalTime> checkOutTime = new HashSet<>();
        checkOutTime.add(checkOut);
                checkOutTime
                        .stream()
                        .filter(check -> ChronoUnit.HOURS.between(LocalTime.now(),LocalTime.MIDNIGHT) != 0)
                        .map(check ->
                        {
                            validCheckOutTime.validate(checkOut);
                            return checkOutTime;
                        })
                .forEach(System.out::println);

                return checkOutTime;
    }

    public Set<LocalTime> getLateCheckOutTime(LocalTime lateCheckOut)
    {
        return List.of(lateCheckOut)
                .stream()
                .filter(p -> ChronoUnit.HOURS.between(LocalTime.of(18,0),LocalTime.MIDNIGHT) != 0)
                .map(p->
                {
                    validLateCheckOutTime.validate(lateCheckOut);
                    return lateCheckOut;
                })
                .collect(Collectors.toSet());
    }

    public double getLateCheckOutTimeByNumbersHours(LocalTime checkOut, LocalTime lateCheckOut)
    {
        long number = ChronoUnit.HOURS.between(checkOut,lateCheckOut);
        log.info("Number hours late check out: " +number);
        return BigDecimal.valueOf(number).doubleValue();
    }

    public double getNumbersHours(LocalTime checkIn, LocalTime checkOut)
    {
        long number = ChronoUnit.HOURS.between(checkIn,checkOut);
        log.info("Number hours : " +number);
        return BigDecimal.valueOf(number).doubleValue();
    }
}
