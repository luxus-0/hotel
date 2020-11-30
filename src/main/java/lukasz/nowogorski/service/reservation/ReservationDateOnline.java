package lukasz.nowogorski.service.reservation;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lukasz.nowogorski.model.ReservationOnline;
import lukasz.nowogorski.repository.ReservationOnlineRepository;
import lukasz.nowogorski.service.validation.*;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Log4j2
public class ReservationDateOnline {

    private final LocalDateTime now = LocalDateTime.now();
    private final ReservationOnlineRepository repository;
    private final ReservationOnlineCreate reservation;
    private final ReservationDays days;
    private final ValidCheckIn validCheckIn;
    private final ValidCheckOut validCheckOut;
    private final ValidReservationDay validDay;
    private final ValidReservationMonth validMonth;
    private final ValidReservationYear validYear;

    public void getDate(LocalDateTime checkIn, LocalDateTime checkOut)
    {
        validCheckIn.validate(checkIn);
        validCheckOut.validate(checkOut);
        validDay.validate(checkIn,checkOut);
        validMonth.validate(checkIn,checkOut);
        validYear.validate(checkIn,checkOut);

        if (checkIn.equals(now)) {
            log.info("Check in today: " + checkIn);
        } else if (checkOut.equals(now)) {
            log.info("Check out today: " + checkOut);
        } else if (checkIn.equals(now) && checkOut.equals(now)) {
            log.info("One day reservation\n" + "Check in: " + checkIn + "\nCheck out: " + checkOut);
        } else if (checkIn.equals(now.plusDays(days.getDays(checkIn, checkOut)))) {
            log.info("check in: " + checkIn);
            log.info("check out: " + checkOut);
        }
        ReservationOnline creator = reservation.create(checkIn, checkOut);
        repository.save(creator);
    }


}
