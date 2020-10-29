package hotel_app.hotel.mapper;

import hotel_app.hotel.dto.ReservationDTO;
import hotel_app.hotel.entity.Reservation;

public interface ReservationMapper {


    Reservation toBooking(ReservationDTO reservationDTO);
    ReservationDTO toBookingDTO(Reservation reservation);

}
