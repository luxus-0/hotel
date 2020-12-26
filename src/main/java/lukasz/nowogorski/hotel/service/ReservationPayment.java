package lukasz.nowogorski.hotel.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
@Log4j2
public class ReservationPayment {

    public BigDecimal getPaymentEarlyCheckIn() {
        log.info("Payment for early check in:");
        return BigDecimal.valueOf(12).multiply(BigDecimal.valueOf(10.3));
    }

    public BigDecimal getPaymentLateCheckIn() {
        log.info("Payment for late check in:");
        return BigDecimal.valueOf(12).multiply(BigDecimal.valueOf(12.3));
    }

    public BigDecimal getPaymentEarlyCheckOut() {
        log.info("Payment for early check out:");
        return BigDecimal.valueOf(14).multiply(BigDecimal.valueOf(11.93));

    }

    public BigDecimal getPaymentLateCheckOut() {
        log.info("Payment for late check out:");
        return BigDecimal.valueOf(17).multiply(BigDecimal.valueOf(4.12));
    }
}
