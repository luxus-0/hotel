package lukasz.nowogorski.service.reservation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalTime;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class Cost {

   /* private final ReservationTime reservationTime;

    public double costLateCheckOut(LocalTime lateCheckOut) {

        if (!lateCheckOutFee.equals(reservationTime.getLateCheckOutTime(lateCheckOut))) {
            double tax = 10.23;
            double numberHoursLate = lateCheckOutFee.doubleValue() - lateCheckOut.doubleValue();
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
    }*/
}
