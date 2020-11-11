package lukasz.nowogorski.domain.service;

import lukasz.nowogorski.domain.model.Reservation;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationService {

    List<Reservation> findReservation();
    Reservation findReservationById(Long id);
    List<Reservation> findReservationByAdultNumber(Integer adultNumber);
    List<Reservation> findReservationByChildrenNumber(Integer childrenNumber);
    List<Reservation> findReservationByExtraBedNumber(Integer extraBedNumber);
    List<Reservation> findReservationByPayment(Boolean isPayment);



    Reservation saveReservation(Reservation reservation);

    Reservation updateReservation(Reservation reservation, Long id);

    void deleteReservation();

    void deleteReservationById(Long id);
}
