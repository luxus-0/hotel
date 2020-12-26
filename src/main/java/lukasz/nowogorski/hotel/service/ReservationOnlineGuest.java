package lukasz.nowogorski.hotel.service;

import lukasz.nowogorski.hotel.exception.ReservationNotFound;
import lukasz.nowogorski.hotel.model.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class ReservationOnlineGuest {
    ReservationOnlineCreator onlineCreator;
    GuestsCreator guestsCreator;

    public Guest addReservationDate(LocalDateTime checkIn,LocalDateTime checkOut)
    {
        Set<ReservationOnline> reservations = new HashSet<>();
        reservations.add(onlineCreator.create(checkIn,checkOut));

        reservations.stream()
                .findAny().orElseThrow(()->new ReservationNotFound("Reservation not found"));

        return Guest.builder()
                .reservationOnlines(reservations)
                .build();

    }

    public ReservationOnline addReservationGuestAndRoom()
    {
        return onlineCreator.create();
    }
}
