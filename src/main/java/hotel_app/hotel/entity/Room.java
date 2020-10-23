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
    private  String price;
    private  Boolean avalaible;

    @OneToOne
    private Booking booking;

    public Room(Long id, Integer beds, Integer personNumber, String price, Boolean avalaible) {
        this.id = id;
        this.beds = beds;
        this.personNumber = personNumber;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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