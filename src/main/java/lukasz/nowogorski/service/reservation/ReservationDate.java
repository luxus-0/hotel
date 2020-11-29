package lukasz.nowogorski.service.reservation;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@AllArgsConstructor
public class ReservationDate {


    public LocalDateTime getCheckInDate()
    {
        LocalDateTime now = LocalDateTime.now();
        List<LocalDateTime> checkInDate = new ArrayList<>();
        checkInDate.add(now);
        checkInDate
                .stream()
                .filter(p -> p.equals(now))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        return now;
    }

    public LocalDateTime getCheckOutDate()
    {
        LocalDateTime after = getCheckInDate().plusDays(getNumberDays());
        List<LocalDateTime> checkOutDate = List.of(after);
        checkOutDate
                .stream()
                .filter(check -> check.isAfter(getCheckInDate()))
                .collect(Collectors.toList())
                .forEach(b -> System.out.println("Check out date: " +b));
        return after;
    }

    public int getNumberDays()
    {
        Period period =  Period.between(getCheckInDate().toLocalDate(),getCheckOutDate().toLocalDate());
        List<Period> numberDays = new ArrayList<>();
        numberDays.add(period);
        numberDays
                .stream()
                .findAny()
                .orElseThrow(RuntimeException::new);
        return period.getDays();
    }

    public int getNumberHours()
    {
       int hours = getNumberDays() * 12;
       log.info("hours: " +hours);
        return hours;
    }

    public int getNumberMonths()
    {
        Period periodMonth =  Period.between(getCheckInDate().toLocalDate(),getCheckOutDate().toLocalDate());
        int months =  periodMonth.getMonths();
        log.info("Months: " +months);
        return months;
    }

    public int getNumberYears()
    {
        Period periodYear =  Period.between(getCheckInDate().toLocalDate(),getCheckOutDate().toLocalDate());
        int years  = periodYear.getYears();
        log.info("Years: " +years);
        return years;
    }

}
