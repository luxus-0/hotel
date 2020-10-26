package hotel_app.hotel.service;

import hotel_app.hotel.repository.BookingDateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.stream.Stream;

@Service
public class BookingDateService {

    private final BookingDateRepository bookingDateRepository;
    private final Logger log = LoggerFactory.getLogger(BookingDateService.class);

    public BookingDateService(BookingDateRepository bookingDateRepository) {
        this.bookingDateRepository = bookingDateRepository;
    }

    public void validBookingDateCheckIn(LocalDate checkInDate)
    {
        if(checkInDate == null)
        {
            log.error("CHECK IN DATE IS EMPTY");
        }
        else {
            Stream.of(bookingDateRepository.findAll())
                    .filter(p -> {
                        bookingDateRepository.findByCheckInDate(checkInDate);

                        return true;
                    })
                    .forEach(System.out::println);
        }
    }

    public void validBookingDateCheckOut(LocalDate checkOutDate)
    {
            if(checkOutDate == null)
            {
                log.error("CHECK OUT DATE IS EMPTY");
            }
            else {
                Stream.of(bookingDateRepository.findAll())
                        .filter(p -> {
                            bookingDateRepository.findByCheckInDate(checkOutDate);

                            return true;
                        })
                        .forEach(System.out::println);
            }

    }
}
