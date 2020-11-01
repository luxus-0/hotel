package hotel_app.hotel.service;

import hotel_app.hotel.entity.Reservation;
import hotel_app.hotel.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@AllArgsConstructor
@Service
public class DeleteReservationService {

    private final ReservationRepository reservationRepository;
    private final Logger log = LoggerFactory.getLogger(DeleteReservationService.class);

    public void delete(Reservation reservation)
    {
        reservationRepository.delete(reservation);
        if(reservationRepository.findAll().isEmpty())
        {
            log.info("DELETE RESERVATION: ");
        }
        else
        {
            log.error("DON'T DELETE RESERVATION");
        }
    }

    public void deleteById(Long id) {
        reservationRepository.deleteById(id);
    }

    public void deleteByCreatedDate(LocalDate createdDate){
        log.info("DELETE RESERVATION BY CREATED DATE");

        reservationRepository.deleteByCreatedDate(createdDate);
    }

    public void deleteByNumberChildren(Integer numberChildren)
    {
        log.info("DELETE RESERVATION BY NUMBER CHILDREN");

        reservationRepository.deleteByNumberChildren(numberChildren);
    }


    public void deleteByNumberAdult(Integer numberAdult)
    {
        log.info("DELETE RESERVATION BY PRICE FOR NIGHT");

        reservationRepository.deleteByNumberAdult(numberAdult);
    }

    public void deleteByNumberBed(Integer numberBed)
    {
        log.info("DELETE RESERVATION BY NUMBER BED");

        reservationRepository.deleteByNumberBed(numberBed);
    }
}
