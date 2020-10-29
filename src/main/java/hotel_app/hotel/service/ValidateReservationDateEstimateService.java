package hotel_app.hotel.service;

import hotel_app.hotel.repository.ReservationDateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.stream.Stream;

@Service
final class ValidateReservationDateEstimateService {

    private final ReservationDateRepository reservationDateRepository;
    private final Logger log = LoggerFactory.getLogger(ReservationDateService.class);

    public ValidateReservationDateEstimateService(ReservationDateRepository reservationDateRepository) {
        this.reservationDateRepository = reservationDateRepository;
    }

    public LocalTime validReservationDateEstimatedCheckInTime(LocalTime estimatedCheckInTime)
    {
        if(estimatedCheckInTime == null)
        {
            log.error("ESTIMATED CHECK IN TIME IS EMPTY");
        }
        else {
            Stream.of(reservationDateRepository.findAll())
                    .filter(p -> {
                        reservationDateRepository.findByEstimatedCheckInTime(estimatedCheckInTime);

                        return true;
                    })
                    .forEach(System.out::println);
        }

        return estimatedCheckInTime;

    }

    public LocalTime validReservationDateEstimatedCheckOutTime(LocalTime estimate)
    {
        if(estimate == null)
        {
            log.error("ESTIMATED CHECK OUT TIME IS EMPTY");
        }
        else {
            Stream.of(reservationDateRepository.findAll())
                    .filter(p -> {
                        reservationDateRepository.findByEstimatedCheckOutTime(estimate);

                        return true;
                    })
                    .forEach(System.out::println);
        }

        return estimate;

    }
}
