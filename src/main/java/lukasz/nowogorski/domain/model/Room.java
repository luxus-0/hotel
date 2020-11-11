package lukasz.nowogorski.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long roomNumber;
    private Long floor;
    private Long beds;
    private Long peopleNumber;
    private RoomStandard roomStandard;
    private Float priceForNight;
    private RoomType roomType;
    private String roomStatus;

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

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }
}
