package hotel_app.hotel.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Room {

    @Id
    private Long id;
    private Integer beds;
    private Integer personNumber;
    private String price;
    private Boolean avalaible;

    @OneToOne
    private Booking booking;



}