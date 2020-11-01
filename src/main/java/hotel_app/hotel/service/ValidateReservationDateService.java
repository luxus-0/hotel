package hotel_app.hotel.service;

import hotel_app.hotel.repository.ReservationDateRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.stream.Stream;

@AllArgsConstructor
@Service
final class ValidateReservationDateService {

    private final ReservationDateRepository reservationDateRepository;
    private final Logger log = LoggerFactory.getLogger(ValidateReservationDateService.class);


    public LocalDate validReservationDateCheckIn(LocalDate checkInDate)
    {
        if(checkInDate == null)
        {
            log.error("CHECK IN DATE IS EMPTY");
        }
        else {
            Stream.of(reservationDateRepository.findAll())
                    .filter(p -> {
                        reservationDateRepository.findByCheckInDate(checkInDate);

                        return true;
                    })
                    .forEach(System.out::println);
        }

        return checkInDate;
    }

    public LocalDate validReservationDateCheckOut(LocalDate checkOutDate)
    {
        if(checkOutDate == null)
        {
            log.error("CHECK OUT DATE IS EMPTY");
        }
        else {
            Stream.of(reservationDateRepository.findAll())
                    .filter(p -> {
                        reservationDateRepository.findByCheckInDate(checkOutDate);

                        return true;
                    })
                    .forEach(System.out::println);
        }

        return checkOutDate;

    }

    public LocalDate validReservationDate(LocalDate checkInDate,LocalDate checkOutDate)
    {
        if(checkInDate == null && checkOutDate == null)
        {
            log.error("CHECK IN DATE IS EMPTY");
            log.error("CHECK OUT DATE IS EMPTY");
        }
        else {
            reservationDateRepository.findAll().stream().filter(p -> {
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
