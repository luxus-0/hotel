package lukasz.nowogorski.domain.service;

import lukasz.nowogorski.domain.model.Reservation;

import java.util.List;

public interface ReservationService {

    List<Reservation> findReservation();
    Reservation findReservationById(Long id);
    List<Reservation> findReservationByAdultNumber(Integer adultNumber);
    List<Reservation> findReservationByChildrenNumber(Integer childrenNumber);
    List<Reservation> findReservationByExtraBedNumber(Integer extraBedNumber);
    List<Reservation> findReservationByPayment(String payment);
    Reservation saveReservation(Reservation reservation);
    Reservation updateReservation(Reservation reservation, Long id);
    void deleteReservation();
    void deleteReservationById(Long id);
}
