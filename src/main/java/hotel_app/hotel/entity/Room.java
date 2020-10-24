package hotel_app.hotel.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Room {

    @Id
    private  Long id;
    private  Integer beds;
    private  Integer personNumber;
    private  Double price;
    private  Double priceForNight;
    private  Boolean available;

    @OneToOne
    private Booking booking;

    public Room(Integer beds, Integer personNumber, Double priceForNight, Double price, Boolean available) {
        this.beds = beds;
        this.personNumber = personNumber;
        this.priceForNight = priceForNight;
        this.price = price;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBeds() {
        return beds;
    }

    public void setBeds(Integer beds) {
        this.beds = beds;
    }

    public Integer getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(Integer personNumber) {
        this.personNumber = personNumber;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPriceForNight() {
        return priceForNight;
    }

    public void setPriceForNight(Double priceForNight) {
        this.priceForNight = priceForNight;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Booking getBooking() {
        return booking;
    }
}