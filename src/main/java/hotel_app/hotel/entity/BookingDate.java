package hotel_app.hotel.entity;


import com.sun.istack.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class BookingDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(nullable = false)
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate checkInDate;

    @Column(nullable = false)
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private  LocalDate checkOutDate;


    @Column(nullable = false)
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime estimatedCheckInTime;

    @Column(nullable = false)
    private final boolean lateCheckout = false;

    @Column(nullable = false)
    private final boolean policyAcknowledged = false;

    public BookingDate() {
    }

    public BookingDate(LocalDate checkInDate, LocalDate checkOutDate, LocalTime estimatedCheckInTime) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.estimatedCheckInTime = estimatedCheckInTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public LocalTime getEstimatedCheckInTime() {
        return estimatedCheckInTime;
    }

    public void setEstimatedCheckInTime(LocalTime estimatedCheckInTime) {
        this.estimatedCheckInTime = estimatedCheckInTime;
    }

    public boolean isLateCheckout() {
        return lateCheckout;
    }

    public boolean isPolicyAcknowledged() {
        return policyAcknowledged;
    }

    public Integer totalDays()
    {
        Logger log = LoggerFactory.getLogger(BookingDate.class);

        DayOfWeek weekCheckIn = checkInDate.getDayOfWeek();
        DayOfWeek weekCheckOut = checkOutDate.getDayOfWeek();

        Integer daysOfMonthCheckIn = weekCheckIn.getValue();
        Integer daysOfMonthCheckOut = weekCheckOut.getValue();

        log.info("TOTAL DAYS : " +(daysOfMonthCheckOut-daysOfMonthCheckIn));
        return daysOfMonthCheckOut - daysOfMonthCheckIn;
    }
}
