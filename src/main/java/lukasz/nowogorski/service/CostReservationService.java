package lukasz.nowogorski.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.stream.Stream;

@Service
@Log4j2
@AllArgsConstructor
public class CostReservationService {

    private final BigDecimal lateCheckOut = BigDecimal.valueOf(13);
    private final BigDecimal lateCheckoutFee = BigDecimal.valueOf(15.45);

    public double costLateCheckOut() {

        if (!lateCheckoutFee.equals(lateCheckOut)) {
            double tax = 10.23;
            double numberHoursLate = lateCheckoutFee.doubleValue() - lateCheckOut.doubleValue();
            double allCostForLateCheckOutDate = tax * numberHoursLate;
            log.info("Number hours late: " + numberHoursLate + "hours");
            log.info("Cost late: " + allCostForLateCheckOutDate);

            Stream.of(numberHoursLate)
                    .filter(a -> numberHoursLate > 2)
                    .forEach(a -> log.info("Your late check out: " +numberHoursLate));

            Stream.of(allCostForLateCheckOutDate)
                    .filter(a -> allCostForLateCheckOutDate > 0)
                    .forEach(a -> log.info("Your cost for: "+ numberHoursLate + "hours" +
                            " = " +allCostForLateCheckOutDate));

            return allCostForLateCheckOutDate;
        }
        return 0;
    }
}