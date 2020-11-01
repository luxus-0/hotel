package hotel_app.hotel.service;

import hotel_app.hotel.entity.Payment;
import hotel_app.hotel.repository.ReservationDateRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
@AllArgsConstructor
final class ReservationDate_LateCheckOutService {

    private final ReservationDateRepository reservationDateRepository;
    private final Logger log = LoggerFactory.getLogger(ReservationDate_LateCheckOutService.class);

    public boolean reservationDateLateCheckOut(boolean lateCheckOut)
    {
        if(lateCheckOut)
        {
            Payment payment = new Payment();
            log.error("ADDITIONAL PAYMENT FOR LATE CHECKOUT");
            payment.getPaymentLateCheckOut();
        }
        else {
            Stream.of(reservationDateRepository.findAll())
                    .filter(p -> {
                        reservationDateRepository.findByLateCheckOutDate(false);

                        return false;
                    })
                    .forEach(System.out::println);
        }

        return lateCheckOut;

    }

}
