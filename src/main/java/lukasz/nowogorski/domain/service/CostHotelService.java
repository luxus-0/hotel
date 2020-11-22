package lukasz.nowogorski.domain.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Log4j2
public class CostHotelService {

    public BigDecimal costLateCheckoutFee()
    {
        BigDecimal lateCheckOut = BigDecimal.valueOf(13);
        BigDecimal lateCheckoutFee = BigDecimal.valueOf(15.45);
        if(!lateCheckoutFee.equals(lateCheckOut))
        {
            float late = lateCheckoutFee.floatValue() - lateCheckOut.floatValue();
            log.info("Late check in Hotel is: " +late + "hours");

        }
        return lateCheckoutFee;
    }

    public void costForHoursLateCheckOut()
    {

    }
}
