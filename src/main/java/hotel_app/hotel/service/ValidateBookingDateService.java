package hotel_app.hotel.service;

import hotel_app.hotel.repository.BookingDateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.stream.Stream;

public class ValidateBookingDateService {

    private final BookingDateRepository bookingDateRepository;
    private final Logger log = LoggerFactory.getLogger(BookingDateService.class);


    public ValidateBookingDateService(BookingDateRepository bookingDateRepository) {
        this.bookingDateRepository = bookingDateRepository;
    }


    public LocalDate validBookingDateCheckIn(LocalDate checkInDate)
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

        return checkInDate;
    }

    public LocalDate validBookingDateCheckOut(LocalDate checkOutDate)
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

        return checkOutDate;

    }

    public LocalDate validBookingDate(LocalDate checkInDate,LocalDate checkOutDate)
    {
        if(checkInDate == null && checkOutDate == null)
        {
            log.error("CHECK IN DATE IS EMPTY");
            log.error("CHECK OUT DATE IS EMPTY");
        }
        else {
            bookingDateRepository.findAll().stream().filter(p -> {
                if(checkInDate.getDayOfMonth() == (checkOutDate.getDayOfMonth()))
                {
                    log.error("CHECK IN DATE IS EQUAL CHECK OUT DATE");
                }
                if(checkInDate.getDayOfMonth() > checkOutDate.getDayOfMonth())
                {
                    log.error("CHECK IN DATE IS MORE THAN CHECK OUT DATE");
                }
                if(checkInDate.getDayOfMonth() < checkOutDate.getDayOfMonth())
                {
                    log.info("CHECK IN DATE :" +checkInDate);
                    log.info("CHECK OUT DATE :" +checkOutDate);
                }
                return true;
            });
        }

        return checkOutDate;

    }


}
