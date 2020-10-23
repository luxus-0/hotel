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
    private  Boolean avalaible;

    @OneToOne
    private Booking booking;

    public Room(Long id, Integer beds, Integer personNumber, Double priceForNight, Double price, Boolean avalaible) {
        this.id = id;
        this.beds = beds;
        this.personNumber = personNumber;
        this.priceForNight = priceForNight;
        this.price = price;
        this.avalaible = avalaible;
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

    public Boolean getAvalaible() {
        return avalaible;
    }

    public void setAvalaible(Boolean avalaible) {
        this.avalaible = avalaible;
    }

    public Booking getBooking() {
        return booking;
    }
}