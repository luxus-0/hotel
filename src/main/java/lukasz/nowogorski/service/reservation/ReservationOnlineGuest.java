package lukasz.nowogorski.service.reservation;

import lukasz.nowogorski.exception.ReservationNotFound;
import lukasz.nowogorski.model.*;
import lukasz.nowogorski.service.guest.GuestsCreator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashSet;
import java.util.Set;

public class ReservationOnlineGuest {
    ReservationOnlineCreator onlineCreator;
    GuestsCreator guestsCreator;

    public Guest addReservationByDate(LocalDateTime checkIn,LocalDateTime checkOut)
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
