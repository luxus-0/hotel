package lukasz.nowogorski.service.reservation;

import lukasz.nowogorski.model.ReservationHotel;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class ReservationHotelCreate {
    public ReservationHotel createCheckIn(LocalTime checkIn) {
        return ReservationHotel.builder()
                .checkIn(checkIn)
                .build();
    }

    public ReservationHotel createCheckOut(LocalTime checkOut) {
        return ReservationHotel.builder()
                .checkOut(checkOut)
                .build();
    }

    public ReservationHotel create(LocalDateTime checkIn, LocalDateTime checkOut)
    {
        return ReservationHotel.builder()
                .checkIn(checkIn.toLocalTime())
                .checkOut(checkOut.toLocalTime())
                .build();
    }
}
