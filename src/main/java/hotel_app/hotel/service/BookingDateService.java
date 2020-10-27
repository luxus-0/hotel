package hotel_app.hotel.service;

import hotel_app.hotel.entity.Payment;
import hotel_app.hotel.repository.BookingDateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class BookingDateService {

    private final BookingDateRepository bookingDateRepository;
    private final Logger log = LoggerFactory.getLogger(BookingDateService.class);

    public BookingDateService(BookingDateRepository bookingDateRepository) {
        this.bookingDateRepository = bookingDateRepository;
    }



    public boolean bookingDateLateCheckOut(boolean lateCheckOut)
    {
        if(lateCheckOut)
        {
            Payment payment = new Payment();
            log.error("ADDITIONAL PAYMENT FOR LATE CHECKOUT");
            payment.getPaymentLateCheckOut();
        }
        else {
            Stream.of(bookingDateRepository.findAll())
                    .filter(p -> {
                        bookingDateRepository.findByLateCheckOutDate(lateCheckOut);

                        return false;
                    })
                    .forEach(System.out::println);
        }

        return lateCheckOut;

    }

    public boolean bookingDatePolicyAcknowledge(boolean policyAcknowledge)
    {
        if(policyAcknowledge)
        {
            log.info("POLICY ACKNOWLEDGE");
        }
        else {
            Stream.of(bookingDateRepository.findAll())
                    .filter(p -> {
                        bookingDateRepository.findByPolicyAcknowledge(policyAcknowledge);

                        return false;
                    })
                    .forEach(System.out::println);
        }

        return policyAcknowledge;

    }
}


