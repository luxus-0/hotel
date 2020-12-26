package lukasz.nowogorski.hotel.service;

import lukasz.nowogorski.hotel.model.ReservationHotel;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReservationHotelCreator {

    public ReservationHotel create(LocalDateTime checkIn, LocalDateTime checkOut)
    {
        return ReservationHotel.builder()
                .checkIn(checkIn)
                .checkOut(checkOut)
                .build();
    }

}
