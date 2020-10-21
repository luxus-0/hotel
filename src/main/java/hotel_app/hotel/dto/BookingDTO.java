package hotel_app.hotel.dto;

import hotel_app.hotel.entity.Booking;
import hotel_app.hotel.entity.Status;

import java.time.LocalDate;

public class BookingDTO {

    private LocalDate createdDate;
    private  Integer numberBed;
    private Integer numberChildren;
    private Integer numberAdult;
    private Status status;

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getNumberBed() {
        return numberBed;
    }

    public void setNumberBed(Integer numberBed) {
        this.numberBed = numberBed;
    }

    public Integer getNumberChildren() {
        return numberChildren;
    }

    public void setNumberChildren(Integer numberChildren) {
        this.numberChildren = numberChildren;
    }

    public Integer getNumberAdult() {
        return numberAdult;
    }

    public void setNumberAdult(Integer numberAdult) {
        this.numberAdult = numberAdult;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


}
