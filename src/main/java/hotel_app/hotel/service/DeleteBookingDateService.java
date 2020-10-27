package hotel_app.hotel.service;

import hotel_app.hotel.entity.BookingDate;
import hotel_app.hotel.repository.BookingDateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class DeleteBookingDateService {

    private final BookingDateRepository bookingDateRepository;
    private final Logger log = LoggerFactory.getLogger(BookingDateService.class);

    public DeleteBookingDateService(BookingDateRepository bookingDateRepository) {
        this.bookingDateRepository = bookingDateRepository;
    }

    public void deleteBookingDate(LocalDate checkInDate, LocalDate checkOutDate, LocalTime estimatedCheckInTime)
    {
        List<BookingDate> findByDate = bookingDateRepository.findAll();

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
