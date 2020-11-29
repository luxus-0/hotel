package lukasz.nowogorski.service.reservation;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

@Service
@AllArgsConstructor
@Log4j2
public class ReservationTime {

    private final ReservationPayment payment;

    private final LocalTime checkInTime = LocalTime.of(14,0);
    private final LocalTime earlyCheckInTime = checkInTime.minusHours(getEarlyHoursCheckIn());
    private final LocalTime lateCheckOutTime = checkInTime.plusHours(getLateHoursCheckIn());

    private final LocalTime checkOutTime = LocalTime.of(12,0);
    private final LocalTime earlyCheckOutTime = checkInTime.minusHours(getEarlyHoursCheckOut());
    private final LocalTime lateCheckInTime = checkInTime.plusHours(getLateHoursCheckOut());

    public LocalTime getCheckInTime(LocalTime checkIn)
    {
        if(checkIn == checkInTime) {
            log.info("Check in time: " + checkIn);
        }
        else if(checkIn == earlyCheckInTime)
        {
            log.info("Early check in time: " +earlyCheckInTime);
            payment.getPaymentByEarlyCheckIn();
        }
        else if(checkIn == lateCheckInTime)
        {
            log.info("Late check in time: " +lateCheckInTime);
            payment.getPaymentByLateCheckIn();
        }

        return checkIn;
    }

    public LocalTime getCheckOutTime(LocalTime checkOut)
    {
        if(checkOut == checkOutTime) {
            log.info("Check out time: " + checkOut);
        }
        else if(checkOut == earlyCheckOutTime)
        {
            log.info("Early check out time: " +earlyCheckOutTime);
            payment.getPaymentByEarlyCheckOut();
        }
        else if(checkOut == lateCheckOutTime)
        {
            log.info("Late check out time: " +lateCheckOutTime);
            payment.getPaymentByLateCheckOut();
        }
        return checkOut;
    }

    public long getEarlyHoursCheckIn() {
        long earlyHours = ChronoUnit.HOURS.between(LocalTime.of(0,0),checkInTime);
            log.info("hours: "+earlyHours);
       if(earlyHours < 0)
       {
            log.info("Incorrect hours: "+earlyHours);
        }
        return earlyHours;
    }

    public long getLateHoursCheckIn() {
       long lateHours =  ChronoUnit.HOURS.between(checkInTime,LocalTime.of(0,0));
            log.info(" hours: "+lateHours);
        if(lateHours < 0)
        {
            log.info("Incorrect hours: "+lateHours);
        }
        return lateHours;
    }

    private long getEarlyHoursCheckOut() {
        long earlyHours =  ChronoUnit.HOURS.between(LocalTime.of(0,0),checkOutTime);
        log.info("hours: "+earlyHours);
        if(earlyHours < 0)
        {
            log.info("Incorrect hours: "+earlyHours);
        }
        return earlyHours;
    }

    private long getLateHoursCheckOut() {
        long lateHours =  ChronoUnit.HOURS.between(checkOutTime,LocalTime.of(0,0));
        log.info("hours: "+lateHours);
        if(lateHours < 0)
        {
            log.info("Incorrect hours: "+lateHours);
        }
        return lateHours;
    }
}
