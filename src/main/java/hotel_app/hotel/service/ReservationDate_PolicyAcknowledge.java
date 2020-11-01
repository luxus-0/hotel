package hotel_app.hotel.service;

import hotel_app.hotel.repository.ReservationDateRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@AllArgsConstructor
@Service
final class ReservationDate_PolicyAcknowledge {

    private final ReservationDateRepository reservationDateRepository;
    private final Logger log = LoggerFactory.getLogger(ReservationDate_PolicyAcknowledge.class);



    public boolean reservationDatePolicyAcknowledge(boolean policyAcknowledge)
    {
        if(policyAcknowledge)
        {
            log.info("POLICY ACKNOWLEDGE");
        }
        else {
            Stream.of(reservationDateRepository.findAll())
                    .filter(p -> {
                        reservationDateRepository.findByPolicyAcknowledge(false);

                        return false;
                    })
                    .forEach(System.out::println);
        }

        return policyAcknowledge;

    }
}
