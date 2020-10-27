package hotel_app.hotel.service;

import hotel_app.hotel.repository.BookingDateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.stream.Stream;

@Service
public class ValidateBookingDateEstimateService {

    private final BookingDateRepository bookingDateRepository;
    private final Logger log = LoggerFactory.getLogger(BookingDateService.class);

    public ValidateBookingDateEstimateService(BookingDateRepository bookingDateRepository) {
        this.bookingDateRepository = bookingDateRepository;
    }

    public LocalTime validBookingDateEstimatedCheckInTime(LocalTime estimatedCheckInTime)
    {
        if(estimatedCheckInTime == null)
        {
            log.error("ESTIMATED CHECK IN TIME IS EMPTY");
        }
        else {
            Stream.of(bookingDateRepository.findAll())
                    .filter(p -> {
                        bookingDateRepository.findByEstimatedCheckInTime(estimatedCheckInTime);

                        return true;
                    })
                    .forEach(System.out::println);
        }

        return estimatedCheckInTime;

    }

    public LocalTime validBookingDateEstimatedCheckOutTime(LocalTime estimate)
    {
        if(estimate == null)
        {
            log.error("ESTIMATED CHECK OUT TIME IS EMPTY");
        }
        else {
            Stream.of(bookingDateRepository.findAll())
                    .filter(p -> {
                        bookingDateRepository.findByEstimatedCheckOutTime(estimate);

                        return true;
                    })
                    .forEach(System.out::println);
        }

        return estimate;

    }
}
