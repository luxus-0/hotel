package lukasz.nowogorski.service.reservation;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lukasz.nowogorski.service.validation.ValidReservationDate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
@AllArgsConstructor
public class ReservationDate {

    private final ValidReservationDate reservationDate;

    public List<LocalDate> getReservation(LocalDate createDate) {
        reservationDate.validate(createDate);
        List<LocalDate> createdDate = new ArrayList<>();
        createdDate.add(LocalDate.now());
        for (LocalDate create : createdDate) {
            log.info("Year: " + create.getYear() +
                        "Month: " + create.getMonth() +
                        "Day: " + create.getDayOfMonth()
            );
        }
        return createdDate;
    }

    public void getCancelReservation(LocalDate cancel) {
        List<LocalDate> delete = getReservation(cancel);
        if (delete.size() > 0) {
            delete.clear();
        }
    }
}
