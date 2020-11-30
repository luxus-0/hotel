package lukasz.nowogorski.service.reservation;

import lukasz.nowogorski.model.ReservationHotel;
import lukasz.nowogorski.model.ReservationOnline;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class ReservationOnlineCreate {
    public ReservationOnline create(LocalDateTime checkIn, LocalDateTime checkOut) {
        return ReservationOnline.builder()
                .checkIn(checkIn)
                .checkOut(checkOut)
                .build();
    }

}
