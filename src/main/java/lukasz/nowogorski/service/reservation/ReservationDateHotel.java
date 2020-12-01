package lukasz.nowogorski.service.reservation;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lukasz.nowogorski.model.ReservationHotel;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@AllArgsConstructor
@Log4j2
public class ReservationDateHotel {
    private final ReservationDateOnline online;

    private final LocalTime checkInHotel = LocalTime.of(14, 0);
    private final LocalTime checkOutHotel = LocalTime.of(12, 0);


    public List<LocalDateTime> getReservationHotel(LocalDateTime checkIn, LocalDateTime checkOut)
    {
        return online.getReservationOnline(checkIn, checkOut);

        if (checkIn.toLocalTime().equals(checkInHotel) && checkOut.toLocalTime().equals(checkOutHotel))
        {
            log.info("Check in: " + checkIn);
            log.info("Check out: " + checkIn);
        }
        else if (checkIn.toLocalTime().isBefore(checkInHotel) &&
                checkOut.toLocalTime().isBefore(checkOutHotel))
        {
            PaymentReservation payment = new PaymentReservation();
            log.info("Early Check in: " + checkIn);
            payment.getPaymentEarlyCheckIn();
            log.info("Early Check out: " + checkOut);
            payment.getPaymentEarlyCheckOut();
        }
        else if (checkIn.toLocalTime().isAfter(checkInHotel) &&
                checkOut.toLocalTime().isAfter(checkOutHotel))
        {
            PaymentReservation payment = new PaymentReservation();
            log.info("Late Check in: " + checkIn);
            payment.getPaymentLateCheckIn();
            log.info("Late Check out: " + checkOut);
            payment.getPaymentLateCheckOut();
        }
    }

}
