package lukasz.nowogorski.service.reservation;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lukasz.nowogorski.model.ReservationHotel;
import lukasz.nowogorski.model.ReservationOnline;
import lukasz.nowogorski.repository.ReservationHotelRepository;
import lukasz.nowogorski.service.validation.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
@AllArgsConstructor
@Log4j2
public class ReservationDateHotel {

    private final LocalTime checkInHotel = LocalTime.of(14,0);
    private final LocalTime checkOutHotel = LocalTime.of(12,0);
    private final LocalDateTime now = LocalDateTime.now();
    private final ReservationPayment payment;
    private final ReservationHotelRepository repository;
    private final ReservationHotelCreate reservation;
    private final ReservationDays days;
    private final ValidCheckIn validCheckIn;
    private final ValidCheckOut validCheckOut;
    private final ValidReservationDay validDay;
    private final ValidReservationMonth validMonth;
    private final ValidReservationYear validYear;

    public void getDate(LocalDateTime checkIn,LocalDateTime checkOut)
    {
        validCheckIn.validate(checkIn);
        validCheckOut.validate(checkOut);
        validDay.validate(checkIn,checkOut);
        validMonth.validate(checkIn,checkOut);
        validYear.validate(checkIn,checkOut);

        if (checkIn.equals(now)) {
            log.info("Check in today: " + checkIn);
        } else if (checkOut.equals(now)) {
            log.info("Check out today: " + checkOut);
        } else if (checkIn.equals(now) && checkOut.equals(now)) {
            log.info("One day reservation\n" + "Check in: " + checkIn + "\nCheck out: " + checkOut);
        } else if (checkIn.equals(now.plusDays(days.getDays(checkIn, checkOut)))) {
            log.info("check in: " + checkIn);
            log.info("check out: " + checkOut);
        }

        ReservationHotel creator = reservation.create(checkIn,checkOut);
        repository.save(creator);

    }

    public void getCheckIn(LocalTime checkIn)
    {
        if(checkIn.equals(checkInHotel) )
        {
            log.info("Check in: " + checkIn);
        }
        else if(!checkIn.isAfter(checkInHotel))
        {
            log.info("Late Check in: " +checkIn);
            payment.getLateCheckIn();
        }
        else if(!checkIn.isBefore(checkInHotel))
        {
            log.info("Early Check in: " +checkIn);
            payment.getEarlyCheckIn();
        }

        ReservationHotel creator = reservation.createCheckIn(checkIn);
        repository.save(creator);
    }

    public void getCheckOut(LocalTime checkOut)
    {
            if(checkOut.equals(checkOutHotel) )
            {
                log.info("Check out: " + checkOut);
            }
            else if(!checkOut.isAfter(checkOutHotel))
            {
                log.info("Late Check out: " +checkOut);
                payment.getLateCheckOut();
            }
            else if(!checkOut.isBefore(checkOutHotel))
            {
                log.info("Early Check out: " +checkOut);
                payment.getEarlyCheckOut();
            }

        ReservationHotel creator = reservation.createCheckOut(checkOut);
        repository.save(creator);
    }

}
