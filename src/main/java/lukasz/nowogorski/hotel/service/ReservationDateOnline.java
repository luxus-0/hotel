package lukasz.nowogorski.hotel.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lukasz.nowogorski.hotel.validation.ValidDate;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Set;

@Service
@AllArgsConstructor
@Log4j2
public class ReservationDateOnline {

    private final ValidDate date;

    public Set<LocalDateTime> getReservationOnline(LocalDateTime checkInOnline, LocalDateTime checkOutOnline)
    {
        date.validate(checkInOnline,checkOutOnline);
        LocalDateTime now = LocalDateTime.now();
        if (checkInOnline.equals(now) && checkOutOnline.equals(now)) {
            log.info("One day reservation\n" + "Check in: "
                    + checkInOnline + "\nCheck out: " + checkOutOnline);
        }
         else if (checkInOnline.equals(now.plusDays(getDays(checkInOnline, checkOutOnline)))) {
            log.info("check in: " + checkInOnline);
            log.info("check out: " + checkOutOnline);
        }

         return Set.of(checkInOnline,checkOutOnline);
    }

    public long getDays(LocalDateTime checkIn, LocalDateTime checkOut)
    {
        return Period.between(checkIn.toLocalDate(), checkOut.toLocalDate()).getDays();
    }

}
