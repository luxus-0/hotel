package lukasz.nowogorski.service.reservation;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Period;

@Service
public class ReservationDays {
    public long getDays(LocalDateTime checkIn, LocalDateTime checkOut) {
        return Period.between(checkIn.toLocalDate(), checkOut.toLocalDate()).getDays();
    }
}
