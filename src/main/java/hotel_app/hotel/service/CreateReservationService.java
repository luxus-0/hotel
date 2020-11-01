package hotel_app.hotel.service;

import hotel_app.hotel.entity.Reservation;
import hotel_app.hotel.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public final class CreateReservationService {

    private final ReservationRepository reservationRepository;
    private final Logger log = LoggerFactory.getLogger(CreateReservationService.class);


    public void create(Reservation reservation)
    {
        if(reservation == null)
        {
            log.info("RESERVATION IS EMPTY");
        }
        else
        {
            reservationRepository.insertReservation();
        }
    }
}
