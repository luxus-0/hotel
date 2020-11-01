package hotel_app.hotel.service;

import hotel_app.hotel.entity.ReservationDate;
import hotel_app.hotel.repository.ReservationDateRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@Service
final class DeleteReservationDateService {

    private final ReservationDateRepository reservationDateRepository;
    private final Logger log = LoggerFactory.getLogger(DeleteReservationDateService.class);


    public void deleteBookingDate(LocalDate checkInDate, LocalDate checkOutDate, LocalTime estimatedCheckInTime)
    {
        List<ReservationDate> findByDate = reservationDateRepository.findAll();

        if(!findByDate.isEmpty())
        {
            log.error("YOU DON'T DELETE BOOKING DATE");
        }
        else
        {
            findByDate.removeIf(p -> checkInDate.getDayOfMonth() >= 1);
            findByDate.removeIf(p -> checkOutDate.getDayOfMonth() >= 1);
            findByDate.removeIf(p -> estimatedCheckInTime.getHour() >= 1);
            findByDate.removeIf(p -> estimatedCheckInTime.getHour() >=1);

            log.info("REMOVE DATE? : " +findByDate.isEmpty());
        }
    }
}
