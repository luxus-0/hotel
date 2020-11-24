package lukasz.nowogorski.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lukasz.nowogorski.model.Hotel;
import lukasz.nowogorski.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Log4j2
@AllArgsConstructor
public class CostReservationService {

    private final BigDecimal lateCheckOut = BigDecimal.valueOf(13);
    private final BigDecimal lateCheckoutFee = BigDecimal.valueOf(15.45);
    private final HotelRepository repository;

    public void costLateCheckoutFee() {

        if (!lateCheckoutFee.equals(lateCheckOut)) {
            double tax = 1.23;
            float numberHoursLate = lateCheckoutFee.floatValue() - lateCheckOut.floatValue();
            double costForHourLate = tax * numberHoursLate;
            log.info("Number hours late: " + numberHoursLate + "hours");
            log.info("Cost late: " + costForHourLate);

        } else {
            Set.of(BigDecimal.valueOf(13)).forEach(System.out::println);
        }

    }
}
