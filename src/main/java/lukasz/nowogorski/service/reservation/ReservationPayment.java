package lukasz.nowogorski.service.reservation;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Log4j2
public class ReservationPayment {

    public double getEarlyCheckIn() {
        return 12.30;
    }

    public double getLateCheckIn() {
        return 12.30;
    }

    public double getEarlyCheckOut() {
        return 12.30;
    }

    public double getLateCheckOut() {
        return 12.30;
    }

    public double getPayment()
    {
        return 12.34;
    }

}