package hotel_app.hotel.service;

import hotel_app.hotel.entity.Reservation;
import hotel_app.hotel.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@AllArgsConstructor
@Service
public final class UpdateReservationService {

    private final ReservationRepository reservationRepository;
    private final Logger log = LoggerFactory.getLogger(UpdateReservationService.class);

    public void update(Reservation reservation, Long id)
    {


        if(reservation.getId().equals(id)) {

            reservationRepository.updateById(reservation.getId());
           reservationRepository.updateByCreatedDate(reservation.getCreatedDate());
           reservationRepository.updateByNumberChildren(reservation.getNumberChildren());
           reservationRepository.updateByNumberAdult(reservation.getNumberAdult());
           reservationRepository.updateByNumberBed(reservation.getNumberBed());

        }
        reservationRepository.save(reservation);
    }

    public void updateById(Long id) {
        reservationRepository.updateById(id);

    }

    public void updateByCreatedDate(LocalDate createdDate) {
    }

    public void updateByBeds(LocalDate createdDate)
    {
        log.info("UPDATE RESERVATION BY CREATED DATE");

        reservationRepository.updateByCreatedDate(createdDate);
    }


    public void updateByNumberChildren(Integer numberChildren)
    {
        log.info("UPDATE RESERVATION BY NUMBER CHILDREN");

        reservationRepository.updateByNumberChildren(numberChildren);
    }

    public void updateByNumberAdult(Integer numberAdult)
    {
        log.info("UPDATE RESERVATION BY NUMBER ADULT");

         reservationRepository.updateByNumberAdult(numberAdult);
    }

    public void updateByNumberBed(Integer numberBed)
    {
        log.info("UPDATE RESERVATION BY NUMBER BED");

        reservationRepository.updateByNumberBed(numberBed);
    }


}
