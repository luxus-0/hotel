package lukasz.nowogorski.domain.service;

import lukasz.nowogorski.domain.model.Hotel;

import java.time.LocalDateTime;
import java.util.List;

public interface HotelService {

    List<Hotel> findCheckIn(LocalDateTime checkIn);
    List<Hotel> findCheckOut(LocalDateTime checkOut);
}
