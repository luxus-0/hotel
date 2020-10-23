package hotel_app.hotel.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Time;
import java.time.LocalDateTime;

@Entity
public class ReservationDates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
   private LocalDateTime createdDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private Time createdTime;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime checkInDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDateTime checkOutDate;

    public void totalDays()
    {

    }

}
