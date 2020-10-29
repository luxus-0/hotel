package hotel_app.hotel.entity;


import com.sun.istack.NotNull;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate checkInDate;
    private  LocalDate checkOutDate;
    private LocalTime estimatedCheckInTime;
    private LocalTime estimatedCheckOutTime;
    private  boolean lateCheckOut;
    private boolean policyAcknowledged;


    public Integer totalDayReservation()
    {
        Logger log = LoggerFactory.getLogger(ReservationDate.class);

        DayOfWeek weekCheckIn = checkInDate.getDayOfWeek();
        DayOfWeek weekCheckOut = checkOutDate.getDayOfWeek();

        Integer daysOfMonthCheckIn = weekCheckIn.getValue();
        Integer daysOfMonthCheckOut = weekCheckOut.getValue();


        log.info("TOTAL DAYS : " +(daysOfMonthCheckOut-daysOfMonthCheckIn));
        return daysOfMonthCheckOut - daysOfMonthCheckIn;
    }
}
