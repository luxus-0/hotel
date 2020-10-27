package hotel_app.hotel.service;

import hotel_app.hotel.entity.BookingDate;
import hotel_app.hotel.repository.BookingDateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Service
public class CreateBookingDateService {

    private final BookingDateRepository bookingDateRepository;
    private final ValidateBookingDateService check;
    private final ValidateBookingDateEstimateService checkEstimate;
    private final Logger log = LoggerFactory.getLogger(CreateBookingDateService.class);

    public CreateBookingDateService(BookingDateRepository bookingDateRepository, ValidateBookingDateService check, ValidateBookingDateEstimateService checkEstimate) {
        this.bookingDateRepository = bookingDateRepository;
        this.check = check;
        this.checkEstimate = checkEstimate;
    }


    public void createBookingDate(LocalDate checkInDate, LocalDate checkOutDate)
    {
        BookingDate bookingDate = new BookingDate();
        bookingDate.setEstimatedCheckInTime(LocalTime.of(11, 0));
        bookingDate.setEstimatedCheckOutTime(LocalTime.of(11, 0));
        LocalTime estimateTimeCheckIn = bookingDate.getEstimatedCheckInTime();
        LocalTime estimateTimeCheckOut = bookingDate.getEstimatedCheckOutTime();

        log.info("Validate Date booking");
        check.validBookingDateCheckIn(checkInDate);
        check.validBookingDateCheckOut(checkOutDate);
        check.validBookingDate(checkInDate,checkOutDate);
        checkEstimate.validBookingDateEstimatedCheckInTime(estimateTimeCheckIn);
        checkEstimate.validBookingDateEstimatedCheckOutTime(estimateTimeCheckOut);



        Set<BookingDate> bookingDates = Set.of(new BookingDate(checkInDate,checkOutDate,estimateTimeCheckIn,estimateTimeCheckOut,true,true));

        bookingDates.stream()
                .filter(p -> p.getCheckInDate().equals(checkInDate)).sorted().forEach(System.out::println);

        bookingDates.stream()
                .filter(p -> p.getCheckOutDate().equals(checkOutDate)).sorted().forEach(System.out::println);

        bookingDates.stream()
                .filter(p -> p.getEstimatedCheckInTime().equals(estimateTimeCheckIn)).sorted().forEach(System.out::println);

        bookingDates.stream()
                .filter(p -> p.getEstimatedCheckOutTime().equals(estimateTimeCheckOut)).sorted().forEach(System.out::println);

    bookingDateRepository.saveAll(bookingDates);
    }
}
