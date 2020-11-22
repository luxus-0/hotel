package lukasz.nowogorski.domain.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Log4j2
public class CostHotelService {

   private final BigDecimal lateCheckOut = BigDecimal.valueOf(13);
    private final BigDecimal lateCheckoutFee = BigDecimal.valueOf(15.45);

    public void costLateCheckoutFee()
    {

        if(!lateCheckoutFee.equals(lateCheckOut))
        {
            double tax = 1.23;
            float numberHoursLate = lateCheckoutFee.floatValue() - lateCheckOut.floatValue();
            double costForHourLate = tax * numberHoursLate;
            log.info("Number hours late: " +numberHoursLate + "hours");
            log.info("Cost late: " + costForHourLate);

        }
    }

}
