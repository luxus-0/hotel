package hotel_app.hotel.service;

import hotel_app.hotel.entity.ReservationDate;
import hotel_app.hotel.repository.ReservationDateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Service
final class CreateReservationDateService {

    private  ValidateReservationDateService check;
    private  ValidateReservationDateEstimateService checkEstimate;

    private final ReservationDateRepository reservationDateRepository;
    private final Logger log = LoggerFactory.getLogger(CreateReservationDateService.class);

    public CreateReservationDateService(ReservationDateRepository reservationDateRepository) {
        this.reservationDateRepository = reservationDateRepository;
    }


    public void createReservationDate(LocalDate checkInDate, LocalDate checkOutDate)
    {
        ReservationDate reservationDate = new ReservationDate();
        reservationDate.setEstimatedCheckInTime(LocalTime.of(11, 0));
        reservationDate.setEstimatedCheckOutTime(LocalTime.of(11, 0));
        LocalTime estimateTimeCheckIn = reservationDate.getEstimatedCheckInTime();
        LocalTime estimateTimeCheckOut = reservationDate.getEstimatedCheckOutTime();

        log.info("Validate Date booking");
        check.validReservationDateCheckIn(checkInDate);
        check.validReservationDateCheckOut(checkOutDate);
        check.validReservationDate(checkInDate,checkOutDate);
        checkEstimate.validReservationDateEstimatedCheckInTime(estimateTimeCheckIn);
        checkEstimate.validReservationDateEstimatedCheckOutTime(estimateTimeCheckOut);



        Set<ReservationDate> reservationDates = Set.of(new ReservationDate(reservationDate.getId(),checkInDate,checkOutDate,estimateTimeCheckIn,estimateTimeCheckOut,true,true));

        reservationDates.stream()
                .filter(p -> p.getCheckInDate().equals(checkInDate)).sorted().forEach(System.out::println);

        reservationDates.stream()
                .filter(p -> p.getCheckOutDate().equals(checkOutDate)).sorted().forEach(System.out::println);

        reservationDates.stream()
                .filter(p -> p.getEstimatedCheckInTime().equals(estimateTimeCheckIn)).sorted().forEach(System.out::println);

        reservationDates.stream()
                .filter(p -> p.getEstimatedCheckOutTime().equals(estimateTimeCheckOut)).sorted().forEach(System.out::println);

    reservationDateRepository.saveAll(reservationDates);
    }
}
