package lukasz.nowogorski.service.reservation;

import lukasz.nowogorski.model.ReservationHotel;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class ReservationHotelCreate {

    public ReservationHotel create(LocalDateTime checkIn, LocalDateTime checkOut)
    {
        return ReservationHotel.builder()
                .checkIn(checkIn)
                .checkOut(checkOut)
                .build();
    }

}
