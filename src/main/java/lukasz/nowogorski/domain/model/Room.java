package lukasz.nowogorski.domain.model;

import javax.persistence.*;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long roomNumber;

    @Column(nullable = false)
    private Long floor;

    @Column(nullable = false)
    private Long beds;

    @Column(nullable = false)
    private Long peopleNumber;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoomStandard roomStandard;

    @Column(nullable = false)
    private Float priceForNight;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    @Column(nullable = false)
    private String status;

    public Room() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Long roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Long getFloor() {
        return floor;
    }

    public void setFloor(Long floor) {
        this.floor = floor;
    }

    public Long getBeds() {
        return beds;
    }

    public void setBeds(Long beds) {
        this.beds = beds;
    }

    public Long getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeopleNumber(Long peopleNumber) {
        this.peopleNumber = peopleNumber;
    }

    public RoomStandard getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(RoomStandard roomStandard) {
        this.roomStandard = roomStandard;
    }

    public Float getPriceForNight() {
        return priceForNight;
    }

    public void setPriceForNight(Float priceForNight) {
        this.priceForNight = priceForNight;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
