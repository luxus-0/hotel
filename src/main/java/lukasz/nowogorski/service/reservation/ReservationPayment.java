package lukasz.nowogorski.service.reservation;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Log4j2
public class ReservationPayment {

    public double getPaymentByEarlyCheckIn() {
        return 12.30;
    }

    public double getPaymentByLateCheckIn() {
        return 12.30;
    }

    public double getPaymentByEarlyCheckOut() {
        return 12.30;
    }

    public double getPaymentByLateCheckOut() {
        return 12.30;
    }



}