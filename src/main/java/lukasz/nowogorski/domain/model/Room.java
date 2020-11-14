package lukasz.nowogorski.domain.model;

import javax.persistence.*;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long roomNumber;
    private Long floor;
    private Long beds;
    private Long peopleNumber;
    private Float priceForNight;
    private String status;
    private RoomStandard roomStandard;
    private RoomType roomType;

    @OneToOne
    private Reservation reservation;

    public Room() {
    }

    public Long getId() {
        return id;
    }


    public Long getRoomNumber() {
        return roomNumber;
    }

    public Long getFloor() {
        return floor;
    }

    public Long getBeds() {
        return beds;
    }

    public Long getPeopleNumber() {
        return peopleNumber;
    }

    public Float getPriceForNight() {
        return priceForNight;
    }

    public String getStatus() {
        return status;
    }

    public RoomStandard getRoomStandard() {
        return roomStandard;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public Reservation getReservation() {
        return reservation;
    }
}
