package hotel_app.hotel.service;

import hotel_app.hotel.entity.Reservation;
import hotel_app.hotel.entity.Room;
import hotel_app.hotel.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Service
public final class ReadReservationService {

    private final ReservationRepository reservationRepository;
    private final Logger log = LoggerFactory.getLogger(ReadReservationService.class);


    public List<Reservation> find()
    {
        log.info("FIND RESERVATION");
        return reservationRepository.findAll();
    }

    public Reservation findById(Long id)
    {
        log.info("FIND RESERVATION BY ID");
        return reservationRepository.findById(id).orElse(null);
    }

    public List<LocalDate> findByCreatedDate(LocalDate createdDate){
        log.info("FIND RESERVATION BY CREATED DATE");

        return reservationRepository.findByCreatedDate(createdDate);
    }

    public List<Integer> findByNumberChildren(Integer numberChildren)
    {
        log.info("FIND RESERVATION BY NUMBER CHILDREN");

        return reservationRepository.findByNumberChildren(numberChildren);
    }


    public List<Integer> findByNumberAdult(Integer numberAdult)
    {
        log.info("FIND RESERVATION BY PRICE FOR NIGHT");

        return reservationRepository.findByNumberAdult(numberAdult);
    }

    public List<Integer> findByNumberBed(Integer numberBed)
    {
        log.info("FIND RESERVATION BY NUMBER BED");

        return reservationRepository.findByNumberBed(numberBed);
    }

}
