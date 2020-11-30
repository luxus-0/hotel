package lukasz.nowogorski.service.reservation;

import lukasz.nowogorski.model.ReservationOnline;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class ReservationOnlineCreate {
    public ReservationOnline create(LocalDateTime checkIn, LocalDateTime checkOut) {
        return ReservationOnline.builder()
                .checkIn(checkIn)
                .checkOut(checkOut)
                .build();
    }

}
